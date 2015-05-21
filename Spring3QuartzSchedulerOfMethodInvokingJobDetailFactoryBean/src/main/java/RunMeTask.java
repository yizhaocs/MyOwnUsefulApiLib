package main.java;

/* Reference: http://www.mkyong.com/spring/spring-quartz-scheduler-example/*/

import java.util.List;

/**
 * Create a normal Java class, this is the class you want to schedule in Quartz.
 */
public class RunMeTask {
    public void printMe(List<String> srcPath) {
        for(String s: srcPath){
            System.out.println("srcPath:" + s);
        }
    }
}