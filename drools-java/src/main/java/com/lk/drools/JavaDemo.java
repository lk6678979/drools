package com.lk.drools;

import org.kie.api.KieBase;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.conf.MaxThreadsOption;
import org.kie.internal.conf.MultithreadEvaluationOption;
import org.kie.internal.utils.KieHelper;

import java.util.ArrayList;

/**
 * JAVA代码生成规则字符串，加载到kie中
 */
public class JavaDemo {

    public static void main(String[] args) {

        String rulestr = "//类似于Java中的import语句，语句的工作方式类似于Java中的import语句。您需要为要在规则中使用的任何对象指定完全限定路径和类型名称\n" +
                "import com.lk.drools.HelloWorldExample.Message;\n" +
                "\n" +
                "//用于定义全局变量\n" +
                "//在代码中给全局变量赋值\n" +
                "//List list = new ArrayList();\n" +
                "//KieSession kieSession = kiebase.newKieSession();\n" +
                "//kieSession.setGlobal( \"list\", list );\n" +
                "global java.util.List list\n" +
                "\n" +
                "//规则名称\n" +
                "rule \"Hello World\"\n" +
                "    //dialect,默认值： 根据package指定,类型：String，\"java\" or \"mvel\"\n" +
                "    //dialect种类是用于LHS或RHS代码块中的任何代码表达式的语言。\n" +
                "    //目前有两种dialect，Java和MVEL。虽然dialect可以在包级别指定，但此属性允许为规则覆盖包定义。\n" +
                "    dialect \"mvel\"\n" +
                "    // 冒号前面的m是在规则结果中引用匹配对象的绑定变量，也就是传进规则引擎的对象\n" +
                "    when\n" +
                "        m : Message( status == Message.HELLO, message : message )\n" +
                "    then\n" +
                "        System.out.println( message );\n" +
                "//        modify ( m ) { setMessage( \"Goodbyte cruel world2222\" ),\n" +
                "//                       setStatus( Message.GOODBYE ) };\n" +
                "    //modify修改对象m的属性\n" +
                "    modify ( m ) { message = \"Goodbye cruel world1111\",\n" +
                "                   status = Message.GOODBYE };\n" +
                "end\n" +
                "\n" +
                "rule \"Good Bye\"\n" +
                "    dialect \"java\"\n" +
                "    when\n" +
                "        Message( status == Message.GOODBYE, message : message )\n" +
                "    then\n" +
                "        System.out.println( message );\n" +
                "end";

        KieBase kieBase = new KieHelper().addContent(rulestr, ResourceType.DRL)
                .build(MultithreadEvaluationOption.YES, MaxThreadsOption.get(3));

        KieSession ksession = kieBase.newKieSession();
        //会话一旦创建，应用程序就可以与之交互
        //在本例中，它将设置一个全局变量，如org/drools/examples/helloworld/HelloWorld.drl文件
        ksession.setGlobal("list", new ArrayList<Object>());

        //设置监听
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        // 设置ThreadedFileLogger，以便审计视图在调试时反映事件，
        // KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );

        // 应用程序可以将事实插入会话(用来校验规则的数据)，同时会出发规则引擎
        final HelloWorldExample.Message message = new HelloWorldExample.Message();
        message.setMessage("Hello World");
        message.setStatus(HelloWorldExample.Message.HELLO);
        ksession.insert(message);

        // 解除规则
        ksession.fireAllRules();

        // 关闭会话
        ksession.dispose();

    }
}
