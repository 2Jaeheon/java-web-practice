package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {
        "/sInit",
        "/sInit2"
    },
    initParams = {
        @WebInitParam(name = "email", value = "admin@jweb.com"),
        @WebInitParam(name = "tel", value = "010-1111-2222"),
    }
)
public class InitParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String email = getInitParameter("email");
        String tel = getInitParameter("tel");
        out.print("<html><body>");
        out.print("<table><tr>");
        out.print("<td>email: </td><td> " + email + "</td></tr>");
        out.print("<tr><td>휴대전화: </td><td>" + tel + "</td>");
        out.print("</tr></table></body></html>");
    }
}
