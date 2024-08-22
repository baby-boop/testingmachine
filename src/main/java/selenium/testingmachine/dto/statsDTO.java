package selenium.testingmachine.dto;

public class statsDTO {
    private int classCount;
    private int errorCount;
    private int warningCount;
    private int workingCount;
    private int infoCount;
    private int processCount;
    private int percent;

    public statsDTO(int classCount, int errorCount, int warningCount, int workingCount, int infoCount, int processCount, int percent) {
        this.classCount = classCount;
        this.errorCount = errorCount;
        this.warningCount = warningCount;
        this.workingCount = workingCount;
        this.infoCount = infoCount;
        this.processCount = processCount;
        this.percent = percent;
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

    public int getInfoCount() {
        return infoCount;
    }

    public void setInfoCount(int infoCount) {
        this.infoCount = infoCount;
    }

    public int getProcessCount() { 
        return processCount; 
    }
    public void setProcessCount(int processCount) { 
        this.processCount = processCount; 
    }

    public int getPercent() { 
        return percent; 
    }
    public void setPercent(int percent) { 
        this.percent = percent; 
    }
}
