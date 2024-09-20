package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        HttpSession session = req.getSession();
        session.setAttribute("name", "이순신");
        pw.println("<html><body>");
        pw.println("<h1>세션에 이름을 바인딩 합니다</h1>");
        pw.println("<a href='/pro12/test01/session.jsp'>첫 번째 페이지로 돌아가기</a>");
        pw.println("</body></html");
    }
}
