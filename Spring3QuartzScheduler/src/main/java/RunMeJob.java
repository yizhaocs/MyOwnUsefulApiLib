package main.java;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/* Reference: http://www.mkyong.com/spring/spring-quartz-scheduler-example/*/
public class RunMeJob extends QuartzJobBean {
	private RunMeTask runMeTask;

	public void setRunMeTask(RunMeTask runMeTask) {
		this.runMeTask = runMeTask;
	}

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		runMeTask.printMe();

	}
}