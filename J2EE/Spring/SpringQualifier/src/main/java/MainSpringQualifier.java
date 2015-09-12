package main.java;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yizhao on 5/28/15.
 */
public class MainSpringQualifier {
    public static void main(String args[]) {
        //Initializing context
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DTO mDTO = (DTO)ctx.getBean("DTO");
        System.out.println(mDTO.getArchivedPath());
        System.out.println(mDTO.getDefaultFS());
        System.out.println(mDTO.getHadoopFS());
        System.out.println(mDTO.getInputPath());
        System.out.println(mDTO.getOutputPath());
        System.out.println(mDTO.getProjectName());
        System.out.println(mDTO.getTestSequenceFile1());
        System.out.println(mDTO.getTestSequenceFile2());
        System.out.println(mDTO.getWorkingPath());
        System.out.println(mDTO.isTest());
    }
}
