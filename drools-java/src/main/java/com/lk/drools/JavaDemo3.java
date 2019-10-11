package com.lk.drools;

import com.sziov.gacnev.qbalarm.entity.dto.GbSignDto2;
import com.sziov.gacnev.qbalarm.entity.po.AlarmPo;
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
public class JavaDemo3 {

    public static void main(String[] args) {

        String rulestr =
                "import java.util.ArrayList\n" +
                        "import java.util.LinkedList\n" +
                        "import com.sziov.gacnev.qbalarm.entity.dto.GbSignDto2\n" +
                        "import com.sziov.gacnev.qbalarm.entity.po.AlarmPo\n" +
                        "import java.util.Map\n" +
                        "\n" +
                        "global java.util.List list\n" +
                        "\n" +
                        "rule \"1002\"\n" +
                        "    dialect \"mvel\"\n" +
                        "    when\n" +
                        "        $gbSignDto : GbSignDto2($signList:signList)\n" +
                        "        $alarmSign : ArrayList(size >= 3)\n" +
                        "                    from collect(Map($signList.size() - this._dataIndex <= 5 && this.INFO_TYPE_1_SIGNAL_1 == 2)\n" +
                        "                     from $signList)\n" +
                        "    then\n" +
                        "        System.out.println( $alarmSign.size()+\":\"+$alarmSign);\n" +
                        "        list.add(new AlarmPo(\"1212\"));\n" +
                        "//    modify ( m ) { message = \"Goodbye cruel world\",\n" +
                        "//                   status = Message.GOODBYE };\n" +
                        "end";

        KieBase kieBase = new KieHelper().addContent(rulestr, ResourceType.DRL)
                .build(MultithreadEvaluationOption.YES, MaxThreadsOption.get(3));

        KieSession ksession = kieBase.newKieSession();
        //会话一旦创建，应用程序就可以与之交互
        //在本例中，它将设置一个全局变量，如org/drools/examples/helloworld/HelloWorld.drl文件
        List<AlarmPo> result = new ArrayList();
        ksession.setGlobal("list", result);

        //设置监听
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        // 设置ThreadedFileLogger，以便审计视图在调试时反映事件，
        // KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );

        // 应用程序可以将事实插入会话(用来校验规则的数据)，同时会出发规则引擎
        Map<String, Object> po1 = new HashMap();
        po1.put("INFO_TYPE_1_SIGNAL_1", "1");
        po1.put("_dataIndex", "0");
        Map<String, Object> po2 = new HashMap<String, Object>();
        po2.put("INFO_TYPE_1_SIGNAL_1", "2");
        po2.put("_dataIndex", "1");
        Map<String, Object> po3 = new HashMap<String, Object>();
        po3.put("INFO_TYPE_1_SIGNAL_1", "1");
        po3.put("_dataIndex", "2");
        Map<String, Object> po4 = new HashMap<String, Object>();
        po4.put("INFO_TYPE_1_SIGNAL_1", "2");
        po4.put("_dataIndex", "3");
        Map<String, Object> po5 = new HashMap<String, Object>();
        po5.put("INFO_TYPE_1_SIGNAL_1", "1");
        po5.put("_dataIndex", "4");
        Map<String, Object> po6 = new HashMap<String, Object>();
        po6.put("INFO_TYPE_1_SIGNAL_1", "2");
        po6.put("_dataIndex", "5");
        Map<String, Object> po7 = new HashMap<String, Object>();
        po7.put("INFO_TYPE_1_SIGNAL_1", "2");
        po7.put("_dataIndex", "6");
        Map<String, Object> po8 = new HashMap<String, Object>();
        po8.put("INFO_TYPE_1_SIGNAL_1", "1");
        po8.put("_dataIndex", "7");
        Map<String, Object> po9 = new HashMap<String, Object>();
        po9.put("INFO_TYPE_1_SIGNAL_1", "2");
        po9.put("_dataIndex", "8");
        Map<String, Object> po10 = new HashMap<String, Object>();
        po10.put("INFO_TYPE_1_SIGNAL_1", "2");
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
        GbSignDto2 gbSignDto = new GbSignDto2();
        gbSignDto.setSignList(list);
        ksession.insert(gbSignDto);
        // 解除规则
        ksession.fireAllRules();

        // 关闭会话
        ksession.dispose();
        System.out.println(result);
    }
}
