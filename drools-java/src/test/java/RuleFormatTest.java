import com.sziov.gacnev.qbalarm.entity.po.AlarmRegulationPo;
import com.sziov.gacnev.qbalarm.service.impl.RuleFormatServiceImpl;

import java.util.ArrayList;
import java.util.List;


/**
 * 规则格式化工具类
 */
public class RuleFormatTest {

    public static void main(String[] args) {
        RuleFormatServiceImpl ruleFormatService = new RuleFormatServiceImpl();
        AlarmRegulationPo alarmRegulationPo1 = new AlarmRegulationPo();
        alarmRegulationPo1.setId(1);
        alarmRegulationPo1.setVehicleTypeCode("1002");
        alarmRegulationPo1.setDataType("0");
        alarmRegulationPo1.setBatteryRemark("27002");
        alarmRegulationPo1.setBatteryType("2144");
        alarmRegulationPo1.setAlarmLevelCode("11002");
        alarmRegulationPo1.setAlarmCode("6002");
        alarmRegulationPo1.setConsecutiveFrames(5);
        alarmRegulationPo1.setErrorFrames(3);
        alarmRegulationPo1.setAutoGenOrder("0");
        alarmRegulationPo1.setAutoGenAlarm("0");
        alarmRegulationPo1.setMergeTime(10);
        alarmRegulationPo1.setDisposalAdvice("处置建议1111");
        alarmRegulationPo1.setFaultDescription("故障描述11111");
        alarmRegulationPo1.setDisposalLevelCode("29003");
        alarmRegulationPo1.setIsEffect(new Byte("1"));
        alarmRegulationPo1.setRegulationType("0");//0:基础报警 1:阈值报警
        alarmRegulationPo1.setDeptId(1212444);
        alarmRegulationPo1.setBaseId(null);//被覆盖的基础报警ID
        alarmRegulationPo1.setDealingBy(1231L);
        alarmRegulationPo1.setRule("INFO_TYPE_1_SIGNAL_1 = 2,INFO_TYPE_1_SIGNAL_2 = 3,INFO_TYPE_1_SIGNAL_3 = 1,INFO_TYPE_1_SIGNAL_7 >= 11 && INFO_TYPE_1_SIGNAL_7 <= 111\"\n");


        AlarmRegulationPo alarmRegulationPo2 = new AlarmRegulationPo();
        alarmRegulationPo2.setId(2);
        alarmRegulationPo2.setVehicleTypeCode("1002");
        alarmRegulationPo2.setDataType("0");
        alarmRegulationPo2.setBatteryRemark("27002");
        alarmRegulationPo2.setBatteryType("2144");
        alarmRegulationPo2.setAlarmLevelCode("11002");
        alarmRegulationPo2.setAlarmCode("6002");
        alarmRegulationPo2.setConsecutiveFrames(5);
        alarmRegulationPo2.setErrorFrames(3);
        alarmRegulationPo2.setAutoGenOrder("1");
        alarmRegulationPo2.setAutoGenAlarm("1");
        alarmRegulationPo2.setMergeTime(10);
        alarmRegulationPo2.setDisposalAdvice("处置建议2222");
        alarmRegulationPo2.setFaultDescription("故障描述2222");
        alarmRegulationPo2.setDisposalLevelCode("29003");
        alarmRegulationPo2.setIsEffect(new Byte("1"));
        alarmRegulationPo2.setRegulationType("1");//0:基础报警 1:阈值报警
        alarmRegulationPo2.setDeptId(1212444);
        alarmRegulationPo2.setBaseId(1);//被覆盖的基础报警ID
        alarmRegulationPo2.setDealingBy(1231L);
        alarmRegulationPo2.setRule("INFO_TYPE_1_SIGNAL_1 = 2,INFO_TYPE_1_SIGNAL_2 = 3,INFO_TYPE_1_SIGNAL_3 = 1,INFO_TYPE_1_SIGNAL_7 >= 11 && INFO_TYPE_1_SIGNAL_7 <= 111\"\n");


        AlarmRegulationPo alarmRegulationPo3 = new AlarmRegulationPo();
        alarmRegulationPo3.setId(3);
        alarmRegulationPo3.setVehicleTypeCode("1002");
        alarmRegulationPo3.setDataType("0");
        alarmRegulationPo3.setBatteryType("2144");
        alarmRegulationPo3.setBatteryRemark("27002");
        alarmRegulationPo3.setAlarmLevelCode("11002");

        alarmRegulationPo3.setAlarmCode("6003");

        alarmRegulationPo3.setConsecutiveFrames(5);
        alarmRegulationPo3.setErrorFrames(3);
        alarmRegulationPo3.setAutoGenOrder("1");
        alarmRegulationPo3.setAutoGenAlarm("1");
        alarmRegulationPo3.setMergeTime(10);

        alarmRegulationPo3.setDisposalAdvice("处置建议3333");
        alarmRegulationPo3.setFaultDescription("故障描述3333");
        alarmRegulationPo3.setDisposalLevelCode("29003");
        alarmRegulationPo3.setIsEffect(new Byte("1"));
        alarmRegulationPo3.setRegulationType("0");//0:基础报警 1:阈值报警
        alarmRegulationPo3.setDeptId(1212444);
        alarmRegulationPo3.setBaseId(null);//被覆盖的基础报警ID
        alarmRegulationPo3.setDealingBy(1231L);
        alarmRegulationPo3.setRule("INFO_TYPE_1_SIGNAL_1 = 2,INFO_TYPE_1_SIGNAL_2 = 3,INFO_TYPE_1_SIGNAL_3 = 1,INFO_TYPE_1_SIGNAL_7 >= 11 && INFO_TYPE_1_SIGNAL_7 <= 111\"\n");

        AlarmRegulationPo alarmRegulationPo4 = new AlarmRegulationPo();
        alarmRegulationPo4.setId(4);
        alarmRegulationPo4.setVehicleTypeCode("1002");
        alarmRegulationPo4.setDataType("0");
        alarmRegulationPo4.setBatteryRemark("27002");
        alarmRegulationPo4.setBatteryType("2144");
        alarmRegulationPo4.setAlarmLevelCode("11002");

        alarmRegulationPo4.setAlarmCode("6004");

        alarmRegulationPo4.setConsecutiveFrames(5);
        alarmRegulationPo4.setErrorFrames(3);
        alarmRegulationPo4.setAutoGenOrder("1");
        alarmRegulationPo4.setAutoGenAlarm("1");
        alarmRegulationPo4.setMergeTime(10);

        alarmRegulationPo4.setDisposalAdvice("处置建议4444");
        alarmRegulationPo4.setFaultDescription("故障描述4444");
        alarmRegulationPo4.setDisposalLevelCode("29003");
        alarmRegulationPo4.setIsEffect(new Byte("1"));
        alarmRegulationPo4.setRegulationType("1");//0:基础报警 1:阈值报警
        alarmRegulationPo4.setDeptId(1212444);
        alarmRegulationPo4.setBaseId(null);//被覆盖的基础报警ID
        alarmRegulationPo4.setDealingBy(1231L);
        alarmRegulationPo4.setRule("INFO_TYPE_1_SIGNAL_1 = 2,INFO_TYPE_1_SIGNAL_2 = 3,INFO_TYPE_1_SIGNAL_3 = 1,INFO_TYPE_1_SIGNAL_7 >= 11 && INFO_TYPE_1_SIGNAL_7 <= 111\"\n");

        AlarmRegulationPo alarmRegulationPo5 = new AlarmRegulationPo();
        alarmRegulationPo5.setId(5);
        alarmRegulationPo5.setVehicleTypeCode("1003");
        alarmRegulationPo5.setDataType("0");
        alarmRegulationPo5.setBatteryRemark("23002");
        alarmRegulationPo5.setBatteryType("2144");
        alarmRegulationPo5.setAlarmLevelCode("11002");

        alarmRegulationPo5.setAlarmCode("6004");

        alarmRegulationPo5.setConsecutiveFrames(5);
        alarmRegulationPo5.setErrorFrames(3);
        alarmRegulationPo5.setAutoGenOrder("1");
        alarmRegulationPo5.setAutoGenAlarm("1");
        alarmRegulationPo5.setMergeTime(10);

        alarmRegulationPo5.setDisposalAdvice("处置建议4444");
        alarmRegulationPo5.setFaultDescription("故障描述4444");
        alarmRegulationPo5.setDisposalLevelCode("29003");
        alarmRegulationPo5.setIsEffect(new Byte("1"));
        alarmRegulationPo5.setRegulationType("1");//0:基础报警 1:阈值报警
        alarmRegulationPo5.setDeptId(1212444);
        alarmRegulationPo5.setBaseId(null);//被覆盖的基础报警ID
        alarmRegulationPo5.setDealingBy(1231L);
        alarmRegulationPo5.setRule("INFO_TYPE_1_SIGNAL_1 = 2,INFO_TYPE_1_SIGNAL_2 = 3,INFO_TYPE_1_SIGNAL_3 = 1,INFO_TYPE_1_SIGNAL_7 >= 11 && INFO_TYPE_1_SIGNAL_7 <= 111\"\n");


        AlarmRegulationPo alarmRegulationPo6 = new AlarmRegulationPo();
        alarmRegulationPo6.setId(6);
        alarmRegulationPo6.setVehicleTypeCode("1003");
        alarmRegulationPo6.setDataType("0");
        alarmRegulationPo6.setBatteryRemark("23002");
        alarmRegulationPo6.setBatteryType("2145");
        alarmRegulationPo6.setAlarmLevelCode("11002");

        alarmRegulationPo6.setAlarmCode("6004");

        alarmRegulationPo6.setConsecutiveFrames(5);
        alarmRegulationPo6.setErrorFrames(3);
        alarmRegulationPo6.setAutoGenOrder("1");
        alarmRegulationPo6.setAutoGenAlarm("1");
        alarmRegulationPo6.setMergeTime(10);

        alarmRegulationPo6.setDisposalAdvice("处置建议4444");
        alarmRegulationPo6.setFaultDescription("故障描述4444");
        alarmRegulationPo6.setDisposalLevelCode("29003");
        alarmRegulationPo6.setIsEffect(new Byte("1"));
        alarmRegulationPo6.setRegulationType("1");//0:基础报警 1:阈值报警
        alarmRegulationPo6.setDeptId(1212444);
        alarmRegulationPo6.setBaseId(null);//被覆盖的基础报警ID
        alarmRegulationPo6.setDealingBy(1231L);
        alarmRegulationPo6.setRule("INFO_TYPE_1_SIGNAL_1 =2,INFO_TYPE_1_SIGNAL_2 = 3,INFO_TYPE_1_SIGNAL_3 = 1,INFO_TYPE_1_SIGNAL_7 >= 11 && INFO_TYPE_1_SIGNAL_7 <= 111\"\n");



        List<AlarmRegulationPo> alarmRegulationPos = new ArrayList();
        alarmRegulationPos.add(alarmRegulationPo1);
        alarmRegulationPos.add(alarmRegulationPo2);
        alarmRegulationPos.add(alarmRegulationPo3);
        alarmRegulationPos.add(alarmRegulationPo4);
        alarmRegulationPos.add(alarmRegulationPo5);
        alarmRegulationPos.add(alarmRegulationPo6);
        System.out.println(ruleFormatService.formatFromRules(alarmRegulationPos));
    }
}
