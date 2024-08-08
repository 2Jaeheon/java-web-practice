package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Date d = new Date();

        //쿠키 객체를 생성한 후 cookieTest이름으로 한글정보를 인코딩해서 쿠키에 저장합니다.
        Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP프로그래밍 입니다.", "utf-8"));
        //쿠키의 유효기간을 설정
        c.setMaxAge(24 * 60 * 60);
        //생성된 쿠키를 브라우저로 전송합니다.
        resp.addCookie(c);

        out.println("현재시간: " + d);
        out.println("문자열을 Cookie에 저장합니다.");
    }
}
