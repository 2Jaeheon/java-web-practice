package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        List membersList = (List) req.getAttribute("membersList");
        out.println("<html><body>");
        out.println("<table border = 1><tr align='center' bgcolor='lightgreen'>");
        out.println("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");

        for (int i = 0; i < membersList.size(); i++) {
            MemberVO memberVO = (MemberVO) membersList.get(i);

            String id = memberVO.getId();
            String pwd = memberVO.getPwd();
            String name = memberVO.getName();
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate();
            out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email
                + "</td><td>" + joinDate + "</td><td>"
                + "<a href='/pro08/member3?command=delMember&id=" + id + "'>삭제</a></td></tr>");
        }
        out.print("</table></body></html>");
        out.print("<a href='pro08/memberForm.html'>새회원 등록하기</a>");
    }
}
