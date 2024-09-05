package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SimpleUrlController implements Controller {

    /*
  	아래 메서드는 Controller 인터페이스의 유일한 메서드입니다.
    HTTP 요청이 이 컨트롤러로 전달될 때 호출됩니다.
	HttpServletRequest와 HttpServletResponse 객체를 인자로 받아 요청과 응답을 처리할 수 있습니다.
	new ModelAndView("index.jsp"): 이 메서드는 "index.jsp"라는 뷰 이름을 가진 ModelAndView 객체를 반환합니다.
	즉, 이 컨트롤러는 index.jsp 페이지로 사용자를 리다이렉트합니다.*/
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        return new ModelAndView("index.jsp");
    }

}
