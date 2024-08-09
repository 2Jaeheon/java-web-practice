package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess4")
public class SessionTest4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        doHandle(req, resp);
    }

    protected void doHandle(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        //로그인 창에서 전송된 id와 비밀번호를 가지고 옵니다.
        String user_id = req.getParameter("user_id");
        String user_pw = req.getParameter("user_pw");

        //최초 요청시 실행
        if (session.isNew()) {
            //로그인창에서 서블릿으로 요청했다면 ID가 널이 아니므로 세션에 ID를 바인딩합니다.
            if (user_id != null) {
                session.setAttribute("user_id", user_id);
                out.println("<a href='sess4'>로그인 상태 확인</a>");
            } else {
                out.println("<a href='login2.html'>다시 로그인하세요!!</a>");
                session.invalidate();
            }
        } else { //재접속시 실행
            //재요청 시 세션에서 ID를 가져와 이전에 로그인했는지 여부를 확인
            user_id = (String) session.getAttribute("user_id");
            if (user_id != null && user_id.length() != 0) {
                out.print("안녕하세요 " + user_id + "님!!!");
            } else {
                out.print("<a href='login2.html'>다시 로그인하세요!!!</a>");
                session.invalidate();
            }
        }
    }
}
