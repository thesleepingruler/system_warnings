package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import service.SystemWarningService;

public class DisplayServlet extends HttpServlet {
    private SystemWarningService service = new SystemWarningService();
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        if (service.getAllWarnings().isEmpty())
            req.setAttribute("popup", "No System Warnings Found.");
        else
            req.setAttribute("logs", service.getAllWarnings());
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);
    }
}
