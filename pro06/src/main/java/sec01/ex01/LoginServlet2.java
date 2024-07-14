package sec01.ex01;

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
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("execute init() method");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("execute destroy() method");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter(); // HttpSerlvetResponse 객체의 getWriter()를 이용해서
                                                // PrintWriter스트림 객체를 받아옴
        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");

        String data = "<html>";
        data += "<body>";
        data += "아이디: " + id + "<br>";
        data += "패스워드: " + pw + "</body></html>";
        out.print(data);
    }

}
