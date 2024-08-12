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

@WebServlet("/login3")
public class LoginTest extends HttpServlet {

    ServletContext context = null;
    List user_list = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        context = getServletContext();
        PrintWriter out = resp.getWriter();
        String user_id = req.getParameter("user_id");
        String user_pw = req.getParameter("user_pw");
        HttpSession session = req.getSession();

        //LoginImpl객체를 생성한 후 아이디와 비밀번호 저장
        LoginImpl loginUser = new LoginImpl(user_id, user_pw);
        //최초 로그인 시 접속자 아이디를 어레이리스트에 차례로 저장한 후 컨텍스트 객체의 속성으로 저장
        if (session.isNew()) {
            session.setAttribute("loginUser", loginUser);
            user_list.add(user_id);
            context.setAttribute("user_list", user_list);
        }

        out.println("<html><body>");
        out.println("아이디는 " + loginUser.user_id + "<br>");
        out.println("총 접속자 수는 " + LoginImpl.total_user + "<br><br>");
        out.println("접속 아이디: <br>");

        //컨텍스트 객체의 어레이리스트를 가져와 접속자 아이디를 브라우저로 출력
        List list = (ArrayList) context.getAttribute("user_list");
        for (int i = 0; i < list.size(); i++) {
            out.println(list.get(i) + "<br>");
        }

        out.println("<a href=logout?user_id=" + user_id + "'>로그아웃</a>");
        out.println("</body></html>");
    }
}
