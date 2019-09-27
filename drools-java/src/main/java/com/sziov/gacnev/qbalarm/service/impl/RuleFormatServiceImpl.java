package com.sziov.gacnev.qbalarm.service.impl;

import com.sziov.gacnev.qbalarm.constant.GbAlarmConstants;
import com.sziov.gacnev.qbalarm.entity.dto.AlarmRegulationDto;
import com.sziov.gacnev.qbalarm.entity.dto.AlarmRuleDrlDto;
import com.sziov.gacnev.qbalarm.entity.po.AlarmRegulationPo;
import com.sziov.gacnev.qbalarm.service.RuleFormatService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleFormatServiceImpl implements RuleFormatService {

    /**
     * 通过数据库的报警规则生成规则引擎drl文件
     */
    public  Map<String, AlarmRuleDrlDto> formatFromRules(List<AlarmRegulationPo> alarmRegulationPos) {
        if (alarmRegulationPos == null || alarmRegulationPos.isEmpty()) {
            return null;
        }

        /**
         * 分类规则
         * 1. 将相同车型和电池配置的规则分到一起
         * 2. MAP结构，key：车型(code)_电池类型(code)，value：规则List
         */
        Map<String, List<AlarmRegulationPo>> classifiedRuleMap = classifyAlarmRegulation(alarmRegulationPos);

        /**
         * 将每个分组好的规则，拼接出drl中的rule（drl的head部分单独写，这里不用写）
         */
        Map<String, AlarmRuleDrlDto> drlMap = new HashMap<String, AlarmRuleDrlDto>();
        for (Map.Entry<String, List<AlarmRegulationPo>> item : classifiedRuleMap.entrySet()) {
            List<AlarmRegulationPo> rules = item.getValue();
            AlarmRuleDrlDto alarmRuleDto = new AlarmRuleDrlDto();
            alarmRuleDto.setHead(getRuleHead());
            for (AlarmRegulationPo ruleItem : rules) {
                alarmRuleDto.addRule(getRuleStrByAlarmRegulationPo(ruleItem));
            }
            drlMap.put(item.getKey(),alarmRuleDto);
        }
        return drlMap;
    }

    @Override
    public String getRuleHead() {
        return "import java.util.ArrayList\n" +
                "import com.sziov.gacnev.qbalarm.entity.dto.GbSignDto\n" +
                "import com.sziov.gacnev.qbalarm.entity.po.GbSignPo\n" +
                "import com.sziov.gacnev.qbalarm.entity.po.AlarmPo\n" +
                "\n" +
                "global java.util.List list\n";
    }

    @Override
    public String getRuleStrByAlarmRegulationPo(AlarmRegulationPo ruleItem) {
        String ruleName = String.valueOf(ruleItem.getId());
        String ruleStr = "\n" +
                "rule \"" + ruleName + "\"\n" +
                "    dialect \"mvel\"\n" +
                "    when\n" +
                "        $gbSignDto : GbSignDto()\n" +
                "        $alarmSign : ArrayList( size >= " + ruleItem.getErrorFrames() + ")\n" +
                "                     from collect(GbSignPo($gbSignDto.signList.size() - $gbSignDto.signList.indexOf(this) <= " + ruleItem.getConsecutiveFrames() + " && " + formatRuleStr(ruleItem.getRule()) + ")\n" +
                "                     from $gbSignDto.signList)\n" +
                "    then\n" +
                "          list.add(new AlarmPo(\"" + ruleItem.getAlarmCode() + "\"));\n" +
                "end\n";
        return ruleStr;
    }

    @Override
    public List<AlarmRegulationDto> recomposeRule(List<AlarmRegulationPo> alarmRegulationPos) {
        //用于将数据库中的报警规则重组，删掉被覆盖的基础报警规则，给需要覆盖基础报警规则的阈值报警规则关联上基础报警对象规则，方便后面遍历生成规则
        List<AlarmRegulationDto> recombinationRule = new ArrayList();
        Map<Integer, AlarmRegulationPo> alarmRegulationMap = new HashMap();
        //将list转为map方式使用表驱动
        for (AlarmRegulationPo item : alarmRegulationPos) {
            alarmRegulationMap.put(item.getId(), item);
        }
        //重组报警规则数据
        //处理所有的阈值报警
        for (AlarmRegulationPo item : alarmRegulationPos) {
            //先处理所有的阈值报警
            if (!GbAlarmConstants.REGULATIONTYPE_THRESHOLD.equals(item.getRegulationType())) {
                continue;
            }
            if (GbAlarmConstants.REGULATIONTYPE_THRESHOLD.equals(item.getRegulationType())) {
                //如果阈值报警没有覆盖基础报警，直接添加到重组的报警规则中
                if (null == item.getBaseId()) {
                    recombinationRule.add(new AlarmRegulationDto(item));
                    //讲已经重组的规则从map去删除
                    alarmRegulationMap.remove(item.getId());
                }
                //如果阈值报警偶覆盖基础报警，将基础报警添加到阈值报警中给，并删除基础报警
                else {
                    AlarmRegulationDto alarmRegulationDto = new AlarmRegulationDto(item);
                    alarmRegulationDto.setBaseRegulation(alarmRegulationMap.get(item.getBaseId()));
                    recombinationRule.add(alarmRegulationDto);
                    //讲已经重组的规则从map去删除
                    alarmRegulationMap.remove(item.getId());
                    alarmRegulationMap.remove(item.getBaseId());
                }
            }
        }
        //剩下的是没有被覆盖的基础报警，直接添加到重组的报警规则中
        if (alarmRegulationMap.size() > 0) {
            for (Map.Entry<Integer, AlarmRegulationPo> item : alarmRegulationMap.entrySet()) {
                recombinationRule.add(new AlarmRegulationDto(item.getValue()));
            }
        }
        return recombinationRule;
    }

    @Override
    public Map<String, List<AlarmRegulationDto>> classifyAlarmRegulationByDto(List<AlarmRegulationDto> recomposedRule) {
        Map<String, List<AlarmRegulationDto>> classifiedRuleMap = new HashMap();
        for (AlarmRegulationDto item : recomposedRule) {
            String key = item.getVehicleTypeCode() + "_" + item.getBatteryType();
            List<AlarmRegulationDto> itemList = classifiedRuleMap.get(key);
            if (itemList == null) {
                itemList = new ArrayList();
                classifiedRuleMap.put(key, itemList);
            }
            itemList.add(item);
        }
        return classifiedRuleMap;
    }

    @Override
    public Map<String, List<AlarmRegulationPo>> classifyAlarmRegulation(List<AlarmRegulationPo> recomposedRule) {
        Map<String, List<AlarmRegulationPo>> classifiedRuleMap = new HashMap();
        for (AlarmRegulationPo item : recomposedRule) {
            String key = item.getVehicleTypeCode() + "_" + item.getBatteryType();
            List<AlarmRegulationPo> itemList = classifiedRuleMap.get(key);
            if (itemList == null) {
                itemList = new ArrayList();
                classifiedRuleMap.put(key, itemList);
            }
            itemList.add(item);
        }
        return classifiedRuleMap;
    }

    @Override
    public String formatRuleStr(String ruleStr) {
        //根据报警项的ID去值列表获取报警的信号Code
        String[] ruleParams = ruleStr.split(",", -1);
        StringBuilder ruleStringBuild = new StringBuilder();
        for (int i = 0; i < ruleParams.length; i++) {
            if (i == ruleParams.length - 1) {
                ruleStringBuild.append(ruleParams[i]);
            } else {
                ruleStringBuild.append(ruleParams[i]).append(" && ");
            }
        }
        return ruleStringBuild.toString();
    }
}
