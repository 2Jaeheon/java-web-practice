package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login3")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        doHandle(req, resp);
    }

    protected void doHandle(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String user_id = req.getParameter("user_id");
        String user_pwd = req.getParameter("user_pw");

        //MemberVO객체를 생성하고 속성에 id와 pwd를 저장
        MemberVO memberVO = new MemberVO();
        memberVO.setId(user_id);
        memberVO.setPwd(user_pwd);
        MemberDAO dao = new MemberDAO();

        //MemberDAO의 isExisted() 메서드를 호출하면서 memberVO를 전달함.
        boolean result = dao.isExisted(memberVO);

        if (result) {
            HttpSession session = req.getSession();
            session.setAttribute("isLogin", true);
            session.setAttribute("login.id", user_id);
            session.setAttribute("login.pwd", user_pwd);

            out.println("<html><body>");
            out.println("안녕하세요 " + user_id + "님!!!<br>");
            out.println("<a href='show'>회원정보 보기</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body><center>회원 아이디가 틀립니다.");
            out.println("<a href='login3.html'>다시 로그인하기</a>");
            out.println("</body></html>");
        }
    }
}
