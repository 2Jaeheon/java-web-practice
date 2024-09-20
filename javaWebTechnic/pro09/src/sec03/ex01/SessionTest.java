package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
        PrintWriter out = resp.getWriter();
        //getSession()을 호출하여 최초 요청 시 세션 객체를 새로 생성하거나 기존 세션을 반환합니다.
        HttpSession session = req.getSession();
        //생성된 세션 객체의 id를 가져옵니다.
        out.println("세션 아이디: " + session.getId() + "<br>");
        out.println("최초 세션 생성 시각: " + new Date(session.getCreationTime()) + "<br>");
        out.println("최근 세션 접근 시각: " + new Date(session.getCreationTime()) + "<br>");
        out.println("세션 유효 시간: " + session.getMaxInactiveInterval() + "<br>");

        if (session.isNew()) {
            out.println("새로운 세션이 만들어졌습니다.");
        }
    }
}
