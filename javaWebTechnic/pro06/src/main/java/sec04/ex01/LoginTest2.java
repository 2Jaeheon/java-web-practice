package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginTest2
 */
@WebServlet(name = "loginTest2", urlPatterns = {"/loginTest2"})
public class LoginTest2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("init method");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("destroy method");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");

        if (id != null && (id.length() != 0)) {
            if (id.equals("admin")) {
                out.print("<html>");
                out.print("<body>");
                out.print("<font size='12'> 관리자로 로그인 하셨습니다!! </font><br>");
                out.print("<input type=button value='회원정보 수정' />");
                out.print("<input type=button value='회원정보 삭제' />");
                out.print("</body>");
                out.print("</html>");
            } else {
                out.print("<html>");
                out.print("<body>");
                out.print(id + "님 로그인 하셨습니다.!! ");
                out.print("</body>");
                out.print("</html>");
            }
        } else {
            out.print("<html>");
            out.print("<body>");
            out.print("ID와 패스워드를 입력하세요!!! <br>");
            out.print("<a href='http://localhost:8080/pro06/test01/login.html'> 로그인 창으로 이동 </a>");
            out.print("</body>");
            out.print("</html>");
        }
    }

}
