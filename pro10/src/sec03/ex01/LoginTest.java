package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        //req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        String user_name = req.getParameter("user_name");
        String user_pw = req.getParameter("user_pw");
        out.println("<html><body>");
        out.println("이름은 " + user_name + "<br>");
        out.println("비밀번호는 " + user_pw + "<br>");
        out.println("</body></html>");
    }
}
