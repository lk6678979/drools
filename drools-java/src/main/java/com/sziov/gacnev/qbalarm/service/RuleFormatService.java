package com.sziov.gacnev.qbalarm.service;

import com.sziov.gacnev.qbalarm.entity.dto.AlarmRegulationDto;
import com.sziov.gacnev.qbalarm.entity.po.AlarmRegulationPo;

import java.util.List;
import java.util.Map;

public interface RuleFormatService {

    /**
     * 获取规则文件drl的head部分
     */
    String getRuleHead();

    /**
     * 根据AlarmRegulationPo对象生成规则Rule字符串
     */
    String getRuleStrByAlarmRegulationPo(AlarmRegulationPo ruleItem);

    /**
     * 重组规则
     * 1.将阈值报警覆盖的基础报警和阈值报警进行关联
     * 2.删除被覆盖的基础报警
     */
    List<AlarmRegulationDto> recomposeRule(List<AlarmRegulationPo> alarmRegulationPos);

    /**
     * 分类规则
     * 1. 将相同车型和电池配置的规则分到一起
     * 2. MAP结构，key：车型(code)_电池类型(code)，value：规则List
     */
    Map<String, List<AlarmRegulationDto>> classifyAlarmRegulationByDto(List<AlarmRegulationDto> recomposedRule);

    /**
     * 分类规则
     * 1. 将相同车型和电池配置的规则分到一起
     * 2. MAP结构，key：车型(code)_电池类型(code)，value：规则List
     */
    Map<String, List<AlarmRegulationPo>> classifyAlarmRegulation(List<AlarmRegulationPo> recomposedRule);

    /**
     * 将数据库中存储的rule格式化，转换逗号为&&
     */
    String formatRuleStr(String ruleStr);
}
