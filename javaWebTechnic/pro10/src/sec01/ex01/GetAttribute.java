package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetAttribute extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ServletContext ctx = getServletContext();
        HttpSession session = req.getSession();

        String ctxMesg = (String) ctx.getAttribute("context");
        String sesMesg = (String) session.getAttribute("session");
        String reqMesg = (String) req.getAttribute("request");

        out.println("context: " + ctxMesg + "<br>");
        out.println("session: " + sesMesg + "<br>");
        out.println("request: " + reqMesg + "<br>");
    }
}
