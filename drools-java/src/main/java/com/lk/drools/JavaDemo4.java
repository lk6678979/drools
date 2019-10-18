package com.lk.drools;

import com.sziov.gacnev.entity.dto.AlarmDto;
import com.sziov.gacnev.entity.dto.AlarmKieDto;
import org.kie.api.KieBase;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.conf.MaxThreadsOption;
import org.kie.internal.conf.MultithreadEvaluationOption;
import org.kie.internal.utils.KieHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生产demo：JAVA代码生成规则字符串，加载到kie中（将需要处理的数据对象改为map）
 * 注意，在遍历list中的map时，无法通过list.indexOf(this)获取下标，建议将
 */
public class JavaDemo4 {

    public static void main(String[] args) {

        String rulestr =
                "import java.util.ArrayList\n" +
                        "import com.sziov.gacnev.entity.dto.AlarmDto\n" +
                        "import com.sziov.gacnev.entity.dto.AlarmKieDto\n" +
                        "import java.util.Map\n" +
                        "\n" +
                        "rule \"16\"\n" +
                        "    dialect \"mvel\"\n" +
                        "    when\n" +
                        "           $alarmKieDto : AlarmKieDto($signList:signList,$lastAlarmInfos:lastAlarmInfos,$currGbInfo:currGbInfo)\n" +
                        "           if ($lastAlarmInfos.containsKey(\"16\") && $currGbInfo['uploadTime'] - $lastAlarmInfos['16'] <=10 " +
                        "           && $currGbInfo['INFO_TYPE_7_SIGNAL_13']==1)  do[stopAlarm]" +
                        "           $alarmSign : ArrayList( size >= 1) \n " +
                        "           from collect(Map($signList.size() - this._dataIndex <= 5  && this.INFO_TYPE_7_SIGNAL_13 == 0 )\n" +
                        "           from $signList)\n" +
                        "    then\n" +
//                        "    $alarmKieDto.resultAlarm.add(new AlarmDto(alarmFlag,ruleId));\n" +
                        "    $alarmKieDto.resultAlarm.add(new AlarmDto( \"6001\", \"16\"));\n" +
//                        " AlarmDto alarmDto = new AlarmDto();\n" +
//                        "        alarmDto.setAlarmFlag(\"6001\");//报警名称编号\n" +
//                        "        alarmDto.setAlarmName(\"报警名称\");\n" +
//                        "        alarmDto.setAlarmJoinTime(10);//合并报警时长\n" +
//                        "        alarmDto.setAutoGenOrder(\"1\");//是否自动生成工单\n" +
//                        "        alarmDto.setDealAdvise(\"处置建议\");\n" +
//                        "        alarmDto.setAlarmLevel(\"报警等级\");\n" +
//                        "        alarmDto.setDealLevel(\"处置等级\");\n" +
//                        "        alarmDto.setFaultDescription(\"故障描述\");"+
//                        "        alarmDto.setRuleId(\"规则ID\");"+
//                        "           $alarmKieDto.resultAlarm.add(alarmDto);\n" +
                        "    then[stopAlarm]\n" +
//                        "           $alarmKieDto.resultAlarm.add(new AlarmDto(\"33333\"));\n" +
                        "end\n";

        KieBase kieBase = new KieHelper().addContent(rulestr, ResourceType.DRL)
                .build(MultithreadEvaluationOption.YES, MaxThreadsOption.get(3));

        KieSession ksession = kieBase.newKieSession();
        //设置监听
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        // 应用程序可以将事实插入会话(用来校验规则的数据)，同时会出发规则引擎
        Map<String, Object> po1 = new HashMap();
        po1.put("INFO_TYPE_7_SIGNAL_13", "1");
        po1.put("_dataIndex", "0");
        Map<String, Object> po2 = new HashMap<String, Object>();
        po2.put("INFO_TYPE_7_SIGNAL_13", "0");
        po2.put("_dataIndex", "1");
        Map<String, Object> po3 = new HashMap<String, Object>();
        po3.put("INFO_TYPE_7_SIGNAL_13", "1");
        po3.put("_dataIndex", "2");
        Map<String, Object> po4 = new HashMap<String, Object>();
        po4.put("INFO_TYPE_7_SIGNAL_13", "0");
        po4.put("_dataIndex", "3");
        Map<String, Object> po5 = new HashMap<String, Object>();
        po5.put("INFO_TYPE_7_SIGNAL_13", "1");
        po5.put("_dataIndex", "4");
        Map<String, Object> po6 = new HashMap<String, Object>();
        po6.put("INFO_TYPE_7_SIGNAL_13", "0");
        po6.put("_dataIndex", "5");
        Map<String, Object> po7 = new HashMap<String, Object>();
        po7.put("INFO_TYPE_7_SIGNAL_13", "2");
        po7.put("_dataIndex", "6");
        Map<String, Object> po8 = new HashMap<String, Object>();
        po8.put("INFO_TYPE_7_SIGNAL_13", "1");
        po8.put("_dataIndex", "7");
        Map<String, Object> po9 = new HashMap<String, Object>();
        po9.put("INFO_TYPE_7_SIGNAL_13", "0");
        po9.put("_dataIndex", "8");
        Map<String, Object> po10 = new HashMap<String, Object>();
        po10.put("INFO_TYPE_7_SIGNAL_13", "1");
        po10.put("_dataIndex", "9");
        List<Map<String, Object>> list = new ArrayList();
        list.add(po1);
        list.add(po2);
        list.add(po3);
        list.add(po4);
        list.add(po5);
        list.add(po6);
        list.add(po7);
        list.add(po8);
        list.add(po9);
        list.add(po10);

        Map<String, Integer> lastAlarmInfos = new HashMap();
        lastAlarmInfos.put("16",564641332);
        Map<String, Object> currGbInfo = new HashMap();
        currGbInfo.put("uploadTime",564641338);
        currGbInfo.put("INFO_TYPE_7_SIGNAL_13",0);
        AlarmKieDto gbSignDto = new AlarmKieDto();
        gbSignDto.setSignList(list);
        gbSignDto.setResultAlarm(new ArrayList<AlarmDto>());
        gbSignDto.setLastAlarmInfos(lastAlarmInfos);
        gbSignDto.setCurrGbInfo(currGbInfo);
        ksession.insert(gbSignDto);
        // 解除规则
        ksession.fireAllRules();

        // 关闭会话
        ksession.dispose();
        System.out.println(gbSignDto.getResultAlarm());
    }
}
