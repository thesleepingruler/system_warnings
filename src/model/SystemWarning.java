package model;

public class SystemWarning {
    private int id;
    private String systemName;
    private String warningMessage;
    private String severityLevel;

    public SystemWarning(int id, String systemName, String warningMessage, String severityLevel) {
        this.id = id;
        this.systemName = systemName;
        this.warningMessage = warningMessage;
        this.severityLevel = severityLevel;
    }

    public int getId() {
        return id;
    }

    public String getSystemName() {
        return systemName;
    }

    public String getWarningMessage() {
        return warningMessage;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }
}
