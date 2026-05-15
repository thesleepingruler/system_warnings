package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Obsolete - Removed in Cyberpunk update
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
}
