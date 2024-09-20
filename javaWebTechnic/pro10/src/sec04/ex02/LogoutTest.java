package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutTest extends HttpServlet {

    ServletContext context;

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
        context = getServletContext();
        PrintWriter out = resp.getWriter();
        String user_id = req.getParameter("user_id");

        //세션을 가져와서 소멸시킨다.
        HttpSession session = req.getSession();
        //로그아웃 시 세션을 소멸
        session.invalidate();

        //user_list에서 로그아웃한 접속자 아이디를 삭제하고 이를 다시 컨텍스트에 저장합니다.
        List user_list = (ArrayList) context.getAttribute("user_list");
        user_list.remove(user_id);

        context.removeAttribute("user_list");
        context.setAttribute("user_list", user_list);
        out.println("<br>로그아웃 하셨습니다");
    }
}
