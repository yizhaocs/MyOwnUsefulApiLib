package main.java.main;

import main.java.dto.TemporaryFileDTO;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yizhao on 5/26/15.
 */
public class MainDTO {
    public static void main(String args[]) {
        //Initializing context
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TemporaryFileDTO chatJob = (TemporaryFileDTO)ctx.getBean("chatJob");
        TemporaryFileDTO friendsJob = (TemporaryFileDTO)ctx.getBean("friendsJob");
        TemporaryFileDTO photosJob = (TemporaryFileDTO)ctx.getBean("photosJob");
        TemporaryFileDTO emailsJob = (TemporaryFileDTO)ctx.getBean("emailsJob");
        System.out.println("chatJob.getArchivedPath(): " + chatJob.getArchivedPath());
        System.out.println("chatJob.getInputPath(): " + chatJob.getInputPath());
        System.out.println("chatJob.getOutputPath(): " + chatJob.getOutputPath());
        System.out.println("chatJob.getProjectName(): " + chatJob.getProjectName());
        System.out.println("chatJob.getWorkingPath(): " + chatJob.getWorkingPath());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("friendsJob.getArchivedPath(): " + friendsJob.getArchivedPath());
        System.out.println("friendsJob.getInputPath(): " + friendsJob.getInputPath());
        System.out.println("friendsJob.getOutputPath(): " + friendsJob.getOutputPath());
        System.out.println("friendsJob.getProjectName(): " + friendsJob.getProjectName());
        System.out.println("friendsJob.getWorkingPath(): " + friendsJob.getWorkingPath());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("photosJob.getArchivedPath(): " + photosJob.getArchivedPath());
        System.out.println("photosJob.getInputPath(): " + photosJob.getInputPath());
        System.out.println("photosJob.getOutputPath(): " + photosJob.getOutputPath());
        System.out.println("photosJob.getProjectName(): " + photosJob.getProjectName());
        System.out.println("photosJob.getWorkingPath(): " + photosJob.getWorkingPath());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("emailsJob.getArchivedPath(): " + emailsJob.getArchivedPath());
        System.out.println("emailsJob.getInputPath(): " + emailsJob.getInputPath());
        System.out.println("emailsJob.getOutputPath(): " + emailsJob.getOutputPath());
        System.out.println("emailsJob.getProjectName(): " + emailsJob.getProjectName());
        System.out.println("emailsJob.getWorkingPath(): " + emailsJob.getWorkingPath());
    }
}
