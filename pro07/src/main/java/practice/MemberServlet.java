package practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "practice2", urlPatterns = {"/practice2"})
public class MemberServlet extends HttpServlet {

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

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        DAO dao = new DAO();
        String command = request.getParameter("command");

        if (command != null && command.equals("addMember")) {
            String _id = request.getParameter("id");
            String _pwd = request.getParameter("pwd");
            String _name = request.getParameter("name");
            String _email = request.getParameter("email");
            VO vo = new VO();

            vo.setId(_id);
            vo.setPwd(_pwd);
            vo.setName(_name);
            vo.setEmail(_email);
            dao.addMember(vo);
        } else if (command != null && command.equals("delMember")) {
            String id = request.getParameter("id");
            dao.delMember(id);
        }

        List<VO> list = dao.makeLists();
        out.print("<html><body>");
        out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
        out.print("<td>이름</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>날짜</td></tr>");

        for (int i = 0; i < list.size(); i++) {
            VO vo = list.get(i);
            String id = vo.getId();
            String pwd = vo.getPwd();
            String name = vo.getName();
            String email = vo.getEmail();
            Date joinDate = vo.getJoinDate();

            out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email
                + "</td><td>" + joinDate + "</td><td>" + "<a href='/pro07/practice?command=delV&id="
                + id + "'>삭제</a></td></tr>");
        }

        out.print("</table></body></html>");
        out.print("<a href='/pro07/memberForm.html'>새 회원 등록하기</a>");
    }
}
