package main.java;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/* Reference: http://www.mkyong.com/spring/spring-quartz-scheduler-example/*/

/**
 * The QuartzJobBean is more flexible and suitable for complex scheduler.
 * You need to create a class extends the Spring’s QuartzJobBean,
 * and define the method you want to schedule in executeInternal() method,
 * and pass the scheduler task (RunMeTask) via setter method.
 */
public class RunMeJob extends QuartzJobBean {
    private RunMeTask runMeTask;
    private String srcPath;

    public void setRunMeTask(RunMeTask runMeTask) {
        this.runMeTask = runMeTask;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {

        //runMeTask.printMe(srcPath);

    }
}