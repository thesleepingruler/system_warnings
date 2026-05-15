package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import service.SystemWarningService;

public class CountServlet extends HttpServlet {
    private SystemWarningService service = new SystemWarningService();
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String msg = service.countWarnings();
        req.setAttribute("popup", msg);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);
    }
}
