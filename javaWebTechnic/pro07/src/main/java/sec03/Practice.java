package sec03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice
 */
@WebServlet(name = "practice", urlPatterns = {"/practice"})
public class Practice extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doHandle(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doHandle(request, response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        DAO dao = new DAO();
        String command = request.getParameter("command");

        // 커맨드 값을 가져와서 add면 추가 del이면 삭제
        if (command != null && command.equals("addV")) {
            String _id = request.getParameter("id");
            String _pwd = request.getParameter("pwd");
            String _name = request.getParameter("name");
            String _email = request.getParameter("email");

            VO vo = new VO();
            vo.setId(_id);
            vo.setPwd(_pwd);
            vo.setName(_name);
            vo.setEmail(_email);
            dao.addV(vo);

        } else if (command != null && command.equals("delV")) {
            String id = request.getParameter("id");
            dao.delV(id);
        }

        List<VO> list = dao.list();
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
                    + "</td><td>" + joinDate + "</td><td>"
                    + "<a href='/pro07/practice?command=delV&id=" + id + "'>삭제</a></td></tr>");
        }
        out.print("</table></body></html>");
        out.print("<a href='/pro07/memberForm.html'>새 회원 등록하기</a>");

    }
}
