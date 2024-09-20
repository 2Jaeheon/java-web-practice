package practice;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer/*")
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo();
        String nextPage = null;

        if (action == null || action.equals("/membersList.do")) {
            List<MemberVO> membersList = memberDAO.listMembers();
            request.setAttribute("membersList", membersList);
            nextPage = "/practice/listMembers.jsp";
        } else if (action.equals("/memberForm.do")) { //멤버 리스트 출력 창에서 회원가입 버튼 눌러서
            // memberForm.do일 때 memberForm.jsp로 이동하도록 설정
            nextPage = "/practice/memberForm.jsp";
        } else if (action.equals("/addMember.do")) { //회원가입 창에서 데이터 전송해서 받아온다음 처리
            //데이터베이스에 form에서 받아온 정보를 전달
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            MemberVO memberVO = new MemberVO(id, pwd, name, email);
            memberDAO.addMember(memberVO);
            nextPage = "/customer/membersList.do";
        } else if (action.equals("/modifyMemberForm.do")) {
            //수정창 눌렀을 때
            String id = request.getParameter("id");
            MemberVO memInfo = memberDAO.findMember(id);
            request.setAttribute("memInfo", memInfo);
            nextPage = "/practice/modMemberForm.jsp";

        } else if (action.equals("/modifyMember.do")) {
            //수정 내용들을 읽어서 처리
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO vo = new MemberVO(id, pwd, name, email);
            memberDAO.modifyMember(vo);
            nextPage = "/customer/membersList.do";
        } else if (action.equals("/delMember.do")) {
            String id = request.getParameter("id");
            memberDAO.delMember(id);
            nextPage = "/customer/membersList.do";
        } else {

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }
}
