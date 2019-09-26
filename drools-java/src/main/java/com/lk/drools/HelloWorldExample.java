package com.lk.drools;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * demo示例（配置文件的方式）
 * 说明：
 * Kie项目具有普通Maven项目的结构，唯一的特点是包括一个kmodule.xml文件，
 * 该文件以声明方式定义了可以从中创建的KieBases和KieSessions。
 * 该文件必须放置在Maven项目的resources / META-INF文件夹中，
 * 而所有其他Kie构件（例如DRL或Excel文件）必须存储在resources文件夹或其下的任何其他子文件夹中
 * KIE将扫描类路径以找到所有带有kmodule.xml的JAR。每个找到的JAR都由KieModule接口表示
 */
public class HelloWorldExample {

    public static final void main(final String[] args) {
        //在kie服务中，从类路径创建一个容器
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        //使用容器之执行一次规则计算的demo
        execute(ks, kc);
    }

    public static void execute(KieServices ks, KieContainer kc) {
        //在容器中，基于resource下的META-INF目录中的.xml文件来常见会话session，方法中指定会话名，如不过指定会话名，会创建一个默认的kbase在使用kbase生成默认的session
        //如果指定了会话名，例如HelloWorldKS，则必须到resources/META-INF创建xml格式的配置文件，指定会画名对应的drl文件packages，例如这个项目中的kmodule.xml
        //这里根据会话名实际是去找配置的kbase（对一个的drl文件），然后去加载drl文件生成kbase对象，然后生成session
        //该方法内部是先创建一个KieSessionModelImpl对象，然后使用者KieSessionModelImpl创建一个KieBase对象，然后kBase.newKieSession创建session
        //我们也可以自己常去创建KieSessionModelImpl对象，然后创建一个KieBase对象，然后kBase.newKieSession创建session
        KieSession ksession = kc.newKieSession("HelloWorldKS");

        //会话一旦创建，应用程序就可以与之交互
        //在本例中，它将设置一个全局变量，如org/drools/examples/helloworld/HelloWorld.drl文件
        ksession.setGlobal("list", new ArrayList<Object>());

        //设置监听
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        // 设置一个基于文件的审计日志程序
        KieRuntimeLogger logger = ks.getLoggers().newFileLogger(ksession, "./helloworld");

        // 设置ThreadedFileLogger，以便审计视图在调试时反映事件，
        // KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );

        // 应用程序可以将事实插入会话(用来校验规则的数据)，同时会出发规则引擎
        final Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        ksession.insert(message);

        // 解除规则
        ksession.fireAllRules();

        // 关闭日志
        logger.close();

        // 关闭会话
        ksession.dispose();
    }

    public static class Message {
        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public Message() {

        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(final String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(final int status) {
            this.status = status;
        }

        public static Message doSomething(Message message) {
            return message;
        }

        public boolean isSomething(String msg, List<Object> list) {
            list.add(this);
            return this.message.equals(msg);
        }
    }

}
