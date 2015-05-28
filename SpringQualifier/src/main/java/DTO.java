package main.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by yizhao on 5/28/15.
 */
public class DTO {
    private String hadoopFS;
    private String defaultFS;
    private String projectName;
    private String inputPath;
    private String workingPath;
    private String outputPath;
    private String archivedPath;
    private String testSequenceFile1;
    private String testSequenceFile2;
    private Boolean test;

    public String getWorkingPath() {
        return workingPath;
    }

    public String getHadoopFS() {
        return hadoopFS;
    }

    public String getDefaultFS() {
        return defaultFS;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getArchivedPath() {
        return archivedPath;
    }

    public String getTestSequenceFile1() {
        return testSequenceFile1;
    }

    public String getTestSequenceFile2() {
        return testSequenceFile2;
    }

    public Boolean isTest() {
        return test;
    }

    @Autowired
    @Qualifier("projectName")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Autowired
    @Qualifier("inputPath")
    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    @Autowired
    @Qualifier("defaultFS")
    public void setDefaultFS(String defaultFS) {
        this.defaultFS = defaultFS;
    }

    @Autowired
    @Qualifier("hadoopFS")
    public void setHadoopFS(String hadoopFS) {
        this.hadoopFS = hadoopFS;
    }

    @Autowired
    @Qualifier("workingPath")
    public void setWorkingPath(String workingPath) {
        this.workingPath = workingPath;
    }

    @Autowired
    @Qualifier("outputPath")
    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    @Autowired
    @Qualifier("archivedPath")
    public void setArchivedPath(String archivedPath) {
        this.archivedPath = archivedPath;
    }

    @Autowired
    @Qualifier("testSequenceFile1")
    public void setTestSequenceFile1(String testSequenceFile1) {
        this.testSequenceFile1 = testSequenceFile1;
    }

    @Autowired
    @Qualifier("testSequenceFile2")
    public void setTestSequenceFile2(String testSequenceFile2) {
        this.testSequenceFile2 = testSequenceFile2;
    }

    @Autowired
    @Qualifier("test")
    public void setTest(Boolean test) {
        this.test = test;
    }
}
