package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import service.SystemWarningService;

public class AddServlet extends HttpServlet {

    private SystemWarningService service = new SystemWarningService();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String sysName = req.getParameter("systemName");
        String msg = req.getParameter("warningMessage");
        String severity = req.getParameter("severityLevel");
        
        String result = service.addWarning(sysName, msg, severity);
        if ("Success".equals(result))
            req.setAttribute("popup", "System Warning Injected Successfully.");
        else
            req.setAttribute("popup", result);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
}
