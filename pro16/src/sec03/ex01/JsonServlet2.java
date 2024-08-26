package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {

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
        PrintWriter writer = response.getWriter();

        JSONObject totalObject = new JSONObject();
        JSONArray membersArray = new JSONArray();
        JSONObject memberInfo = new JSONObject();

        memberInfo.put("name", "박지성");
        memberInfo.put("age", "25");
        memberInfo.put("gender", "남자");
        memberInfo.put("nickname", "날센돌이");
        membersArray.add(memberInfo);

        memberInfo = new JSONObject();
        memberInfo.put("name", "김연아");
        memberInfo.put("age", "21");
        memberInfo.put("gender", "여자");
        memberInfo.put("nickname", "칼치");
        membersArray.add(memberInfo);

        totalObject.put("members", membersArray);
        String jsonInfo = totalObject.toJSONString();
        System.out.println(jsonInfo);
        writer.print(jsonInfo);
    }
}
