package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

    public void init() {
        System.out.println("init method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String user_id = req.getParameter("user_id");
        String user_pw = req.getParameter("user_pw");
        String user_address = req.getParameter("user_address");

        out.println("<html><body>");
        if (user_id != null && user_id.length() != 0) {
            out.println("이미 로그인 상태입니다.<br><br>");
            out.println("첫 번째 서블릿에서 넘겨준 아이디: " + user_id + "<br>");
            out.println("첫 번째 서블릿에서 넘겨준 비밀번호: " + user_pw + "<br>");
            out.println("첫 번째 서블릿에서 넘겨준 주소: " + user_address + "<br>");
            out.println("</body></html>");
        } else {
            out.println("로그인 하지 않았습니다.<br><br>");
            out.println("다시 로그인하세요 !! <br>");
            out.println("<a href='/pro09/login.html'>로그인 창으로 이동하기 </>");
        }
    }
}
