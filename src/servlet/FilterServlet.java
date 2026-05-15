package servlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import service.SystemWarningService;

public class FilterServlet extends HttpServlet {
    SystemWarningService service = new SystemWarningService();
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        if (service.getAllWarnings().isEmpty())
            req.setAttribute("popup", "No System Warnings Found.");
        else if (service.getFilteredWarnings().isEmpty())
            req.setAttribute("popup", "No CPU Warnings Found.");
        req.setAttribute("logs", service.getFilteredWarnings());
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);
    }
}
