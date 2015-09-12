package main.java;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yizhao on 4/22/15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Properties mKafkaConsumerProperties = (Properties) ctx.getBean("Properties");
        boolean flag = mKafkaConsumerProperties.isFlag();
        System.out.println("Flag:" + flag);
    }
}
