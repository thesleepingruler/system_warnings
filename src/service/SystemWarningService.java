package service;

import dao.SystemWarningDAO;
import model.SystemWarning;
import java.util.List;

public class SystemWarningService {

    private SystemWarningDAO dao = new SystemWarningDAO();

    public String addWarning(String systemName, String warningMessage, String severityLevel) {
        if (systemName == null || systemName.trim().isEmpty() || 
            warningMessage == null || warningMessage.trim().isEmpty() ||
            severityLevel == null || severityLevel.trim().isEmpty()) {
            return "Invalid Input: All fields are required.";
        }
        
        try {
            boolean success = dao.addWarning(systemName.trim(), warningMessage.trim(), severityLevel.trim());
            return success ? "Success" : "Failed to insert record.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Database Error: " + e.getMessage();
        }
    }

    public String countWarnings() {
        int count = dao.countWarnings();
        return "Total System Warnings: " + count;
    }

    public String getAllWarnings() {
        return format(dao.getAllWarnings());
    }

    public String getFilteredWarnings() {
        return format(dao.getFilteredWarnings());
    }

    private String format(List<SystemWarning> warnings) {
        if (warnings.isEmpty()) return "";
        StringBuffer sb = new StringBuffer();
        for (SystemWarning warning : warnings) {
            sb.append("[\n  ID: ")
              .append(warning.getId())
              .append(" | SYSTEM: ")
              .append(warning.getSystemName())
              .append(" | SEVERITY: ")
              .append(warning.getSeverityLevel())
              .append("\n  MSG: ")
              .append(warning.getWarningMessage().replace("\n", "\n  "))
              .append("\n]\n");
        }
        return sb.toString().trim();
    }
}
