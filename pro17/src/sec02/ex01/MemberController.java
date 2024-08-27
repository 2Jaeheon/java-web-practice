package sec02.ex01;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {

    MemberDAO memberDAO;

    @Override
    public void init() throws ServletException {
        memberDAO = new MemberDAO();
    }

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

    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nextPage = null;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        //URL에서 요청 명을 가져옵니다.
        String action = request.getPathInfo();
        System.out.println("action: " + action);

        //최초 요청이거나 /listMembers.do면 회원목록 출력
        if (action == null || action.equals("/listMembers.do")) {
            List<MemberVO> membersList = memberDAO.listMembers();
            request.setAttribute("membersList", membersList);
            nextPage = "/test02/listMembers.jsp";
        } else if (action.equals("/addMember.do")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO memberVO = new MemberVO(id, pwd, name, email);
            memberDAO.addMember(memberVO);
            nextPage = "/member/listMembers.do";
        } else if (action.equals("/memberForm.do")) {
            nextPage = "/test02/memberForm.jsp";
        } else { //그 외의 다른 action은 회원 목록을 출력함.
            List<MemberVO> membersList = memberDAO.listMembers();
            request.setAttribute("membersList", membersList);
            nextPage = "/test02/listMembers.jsp";
        }
        //nextPage에 지정한 요청명으로 다시 서블릿으로 요청
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);

    }

}
