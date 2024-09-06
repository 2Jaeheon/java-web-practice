package com.spring.member.controller;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberControllerImpl extends MultiActionController implements MemberController {

    private MemberService memberService;

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }


    //member/memberForm.do로 요청시 호출
    public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        String viewName = getViewName(request);
        ModelAndView mav = new ModelAndView(viewName);
        return mav;
    }

    // member/listMembers.do로 요청시 호출
    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response)
        throws Exception {

        String viewName = getViewName(request);
        List membersList = memberService.listMembers();
        ModelAndView mav = new ModelAndView(viewName);
        //addObject 메서드를 이용해서 조회한 회원정보를 바인딩
        mav.addObject("membersList", membersList);
        return mav;
    }

    // member/addMember.do로 요청시 호출
    public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        request.setCharacterEncoding("utf-8");
        MemberVO memberVO = new MemberVO();
        memberVO.setId(request.getParameter("id"));
        memberVO.setPwd(request.getParameter("pwd"));
        memberVO.setName(request.getParameter("name"));
        memberVO.setEmail(request.getParameter("email"));
        int result = memberService.addMember(memberVO);
        ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
        return mav;
    }

    private String getViewName(HttpServletRequest request) throws Exception {
        String contextPath = request.getContextPath();
        String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
        if (uri == null || uri.trim().equals("")) {
            uri = request.getRequestURI();
        }

        int begin = 0;
        if (!((contextPath == null) || ("".equals(contextPath)))) {
            begin = contextPath.length();
        }

        int end;
        if (uri.indexOf(";") != -1) {
            end = uri.indexOf(";");
        } else if (uri.indexOf("?") != -1) {
            end = uri.indexOf("?");
        } else {
            end = uri.length();
        }

        String fileName = uri.substring(begin, end);
        if (fileName.indexOf(".") != -1) {
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        }
        if (fileName.lastIndexOf("/") != -1) {
            fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
        }
        return fileName;
    }
}
