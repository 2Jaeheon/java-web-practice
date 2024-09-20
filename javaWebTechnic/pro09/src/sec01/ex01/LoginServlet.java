package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String user_id = req.getParameter("user_id");
        String user_pw = req.getParameter("user_pw");
        String user_address = req.getParameter("user_address");
        String user_email = req.getParameter("user_email");
        String user_hp = req.getParameter("user_hp");

        String data = "안녕하세요<br>로그인 하셨습니다. <br><br>";
        data += "<html><body>";
        data += "아이디 : " + user_id + "<br>";
        data += "패스워드 : " + user_pw + "<br>";
        data += "주소 : " + user_address + "<br>";
        data += "email : " + user_email + "<br>";
        data += "휴대전화 : " + user_hp;
        data += "</body></html>";
    }
}
