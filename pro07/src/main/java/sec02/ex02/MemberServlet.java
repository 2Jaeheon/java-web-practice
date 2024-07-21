package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet(name = "member4", urlPatterns = {"/member4"})
public class MemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("init method");
    }

    /**
     * @see Servlet#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("destroy method");
    }

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
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        MemberDAO dao = new MemberDAO();
        PrintWriter out = response.getWriter();
        String command = request.getParameter("command");

        // 커맨드 값을 가져와서 addMember이면 회원 정보를 받아옴
        if (command != null && command.equals("addMember")) {
            String _id = request.getParameter("id");
            String _pwd = request.getParameter("pwd");
            String _name = request.getParameter("name");
            String _email = request.getParameter("email");
            MemberVO vo = new MemberVO();
            vo.setId(_id);
            vo.setPwd(_pwd);
            vo.setName(_name);
            vo.setEmail(_email);
            dao.addMember(vo);
            // delMember이면 회원 정보 삭제
        } else if (command != null && command.equals("delMember")) {
            String id = request.getParameter("id");
            dao.delMember(id);
        }
        //
        List<MemberVO> list = dao.listMembers();
        out.print("<html><body>");
        out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");

        for (int i = 0; i < list.size(); i++) {
            MemberVO memberVO = list.get(i);
            String id = memberVO.getId();
            String pwd = memberVO.getPwd();
            String name = memberVO.getName();
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate();
            out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email
                    + "</td><td>" + joinDate + "</td><td>"
                    + "<a href='/pro07/member4?command=delMember&id=" + id + "'>삭제 </a></td></tr>");
        }
        out.print("</table></body></html>");
        out.print("<a href='/pro07/memberForm.html'>새 회원 등록하기</a>");
    }


}
