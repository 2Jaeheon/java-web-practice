package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class GetCookieValue extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //request의 getCookies()메소드를 호출해 브라우저에게 쿠키정보를 요청한 후 쿠키 정보를 배열로 가져옵니다.
        Cookie[] allValues = req.getCookies();
        //배열에 저장할 때 사용한 쿠키 이름인 cookieTest로 검색해서 쿠키 값을 가져옵니다.
        for (int i = 0; i < allValues.length; i++) {
            if (allValues[i].getName().equals("cookieTest")) {
                out.println(
                    "<h2>Cookie 값 가져오기: " + URLDecoder.decode(allValues[i].getValue(), "utf-8"));
            }

        }
    }
}
