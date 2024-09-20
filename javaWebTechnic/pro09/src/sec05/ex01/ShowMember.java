package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/show")
public class ShowMember extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String id = "", pwd = "";
        Boolean isLogin = false;

        HttpSession session = req.getSession(false);
        //세션이 없다면
        if (session != null) {
            isLogin = (Boolean) session.getAttribute("isLogin");
            if (isLogin) {
                id = (String) session.getAttribute("login.id");
                pwd = (String) session.getAttribute("login.pwd");
                out.println("<html><body>");
                out.println("아이디: " + id + "<br>");
                out.println("비밀번호: " + pwd + "<br>");
                out.println("</body></html>");
            } else {
                //로그인 상태가 아니면 로그인 창으로 이동
                resp.sendRedirect("login3.html");
            }
        } else {
            //세션이 생성되지 않았으면 로그인 창으로 이동
            resp.sendRedirect("login3.html");
        }
    }
}
