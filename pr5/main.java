import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class main extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String val = req.getParameter("c1");
        Cookie c1 = new Cookie("1", val),
                c2 = new Cookie("2", val);
        res.addCookie(c1);
        res.addCookie(c2);
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<center><font color='red'>SAMPLE COOKIES</font></center>");
        out.println("<font color='green'>FIRST NAME:" + req.getParameter("fn") + "</font>");
        out.println("<font color='green'>LAST NAME:" + req.getParameter("ln") + "</font>");
    }
}