package main.java;

/* Reference: http://www.mkyong.com/spring/spring-quartz-scheduler-example/*/

/**
 * Create a normal Java class, this is the class you want to schedule in Quartz.
 */
public class RunMeTask {
    public void printMe() {
        System.out.println("Spring 3 + Quartz 1.8.6 ~");
    }
}