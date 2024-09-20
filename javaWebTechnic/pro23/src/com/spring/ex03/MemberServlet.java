package com.spring.ex03;

import com.spring.ex01.MemberVO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem3.do")
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

    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        MemberDAO dao = new MemberDAO();
        MemberVO memberVO = new MemberVO();
        String action = request.getParameter("action");
        String nextPage = "";

        if (action == null || action.equals("listMembers")) {
            List<MemberVO> membersList = dao.selectAllMemberList();
            request.setAttribute("membersList", membersList);
            nextPage = "test02/listMembers.jsp";


        } else if (action.equals("selectMemberById")) {
            String id = request.getParameter("value");
            memberVO = dao.selectMemberById(id);
            request.setAttribute("member", memberVO);
            nextPage = "test02/memberInfo.jsp";


        } else if (action.equals("selectMemberByPwd")) {
            String pwd = request.getParameter("value");
            List<MemberVO> membersList = dao.selectMemberByPwd(pwd);
            request.setAttribute("membersList", membersList);
            nextPage = "test02/listMembers.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);

    }
}
