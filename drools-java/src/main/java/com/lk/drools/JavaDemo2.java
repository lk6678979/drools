package com.lk.drools;

import com.sziov.gacnev.qbalarm.entity.dto.GbSignDto;
import com.sziov.gacnev.qbalarm.entity.po.AlarmPo;
import com.sziov.gacnev.qbalarm.entity.po.GbSignPo;
import org.kie.api.KieBase;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.conf.MaxThreadsOption;
import org.kie.internal.conf.MultithreadEvaluationOption;
import org.kie.internal.utils.KieHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产demo：JAVA代码生成规则字符串，加载到kie中
 */
public class JavaDemo2 {

    public static void main(String[] args) {

        String rulestr =
                "import java.util.ArrayList\n" +
                "import com.sziov.gacnev.qbalarm.entity.dto.GbSignDto\n" +
                "import com.sziov.gacnev.qbalarm.entity.po.GbSignPo\n" +
                "import com.sziov.gacnev.qbalarm.entity.po.AlarmPo\n" +
                "\n" +
                "global java.util.List list\n" +
                "\n" +
                "rule \"1002\"\n" +
                "    dialect \"mvel\"\n" +
                "    when\n" +
                "        $gbSignDto : GbSignDto()\n" +
                "        $alarmSign : ArrayList( size >= 3)\n" +
                "                     from collect(GbSignPo($gbSignDto.getSignList().size() - $gbSignDto.getSignList().indexOf(this) <= 5 && INFO_TYPE_1_SIGNAL_1==2)\n" +
                "                     from $gbSignDto.getSignList())\n" +
                "    then\n" +
                "        System.out.println( $alarmSign );\n" +
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
        GbSignPo po1 = new GbSignPo();
        po1.setINFO_TYPE_1_SIGNAL_1("1");
        GbSignPo po2 = new GbSignPo();
        po2.setINFO_TYPE_1_SIGNAL_1("2");
        GbSignPo po3 = new GbSignPo();
        po3.setINFO_TYPE_1_SIGNAL_1("1");
        GbSignPo po4 = new GbSignPo();
        po4.setINFO_TYPE_1_SIGNAL_1("2");
        GbSignPo po5 = new GbSignPo();
        po5.setINFO_TYPE_1_SIGNAL_1("1");
        GbSignPo po6 = new GbSignPo();
        po6.setINFO_TYPE_1_SIGNAL_1("2");
        GbSignPo po7 = new GbSignPo();
        po7.setINFO_TYPE_1_SIGNAL_1("2");
        GbSignPo po8 = new GbSignPo();
        po8.setINFO_TYPE_1_SIGNAL_1("1");
        GbSignPo po9 = new GbSignPo();
        po9.setINFO_TYPE_1_SIGNAL_1("2");
        GbSignPo po10 = new GbSignPo();
        po10.setINFO_TYPE_1_SIGNAL_1("2");
        List<GbSignPo> list = new ArrayList();
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
        GbSignDto gbSignDto = new GbSignDto();
        gbSignDto.setSignList(list);
        ksession.insert(gbSignDto);
    // 解除规则
        ksession.fireAllRules();

    // 关闭会话
        ksession.dispose();
        System.out.println(result);
}
}
