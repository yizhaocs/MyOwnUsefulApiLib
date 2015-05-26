package main.java.dto;

/**
 * Created by yizhao on 5/26/15.
 */
public class TemporaryFileDTO {
    private String projectName;
    private String inputPath;
    private String workingPath;
    private String outputPath;
    private String archivedPath;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getArchivedPath() {
        return archivedPath;
    }

    public void setArchivedPath(String archivedPath) {
        this.archivedPath = archivedPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getWorkingPath() {
        return workingPath;
    }

    public void setWorkingPath(String workingPath) {
        this.workingPath = workingPath;
    }

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }
}
