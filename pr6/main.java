import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class main extends HttpServlet {
    int c = 0;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException

    {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        c++;
        out.println("since loading,this servlet hasbeen accessed" + c + "times");
    }
}