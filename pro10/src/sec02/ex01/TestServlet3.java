package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class TestServlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String context = req.getContextPath();
        String url = req.getRequestURL().toString();
        String mapping = req.getServletPath();
        String uri = req.getRequestURI();
        out.println("<html><head><title>TestServlet3</title></head>");
        out.println("<body bgcolor = 'red'><b>TestServlet3입니다.</b><br>");
        out.println("<b>컨텍스트 이름: " + context + "</b><br>");
        out.println("<b>전체 경로: " + url + "<b><br>");
        out.println("<b>매핑 이름: " + mapping + "<b><br>");
        out.println("<b>URI: " + uri + "<b>");
        out.println("</body></html>");
        out.close();
    }
}
