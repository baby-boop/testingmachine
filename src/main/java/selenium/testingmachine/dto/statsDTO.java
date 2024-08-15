package selenium.testingmachine.dto;

public class statsDTO {
    private int classCount;
    private int errorCount;
    private int warningCount;
    private int workingCount;

    public statsDTO(int classCount, int errorCount, int warningCount, int workingCount) {
        this.classCount = classCount;
        this.errorCount = errorCount;
        this.warningCount = warningCount;
        this.workingCount = workingCount;
    }

    public int getWorkingClassCount() {
        return workingCount;
    }

    public void setWorkingClassCount(int workingCount) {
        this.workingCount = workingCount;
    }

    public int getClassCount() {
        return classCount;
    }

    public void setClassCount(int classCount) {
        this.classCount = classCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public int getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(int warningCount) {
        this.warningCount = warningCount;
    }
}
