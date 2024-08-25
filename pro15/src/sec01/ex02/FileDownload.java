package sec01.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownload extends HttpServlet {

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
        response.setContentType("text/html; charset=utf-8");
        String file_repo = "/Users/jaeheon/Desktop/Programming/webStudy/java-web-practice/file_repo";
        String fileName = (String) request.getParameter("fileName");
        System.out.println("fileName = " + fileName);

        OutputStream out = response.getOutputStream();
        String downFile = file_repo + File.separator + fileName;

        File f = new File(downFile);
        response.setHeader("Cache-Control", "no-cache");
        response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
        FileInputStream in = new FileInputStream(f);
        byte[] buffer = new byte[1024 * 8];

        while (true) {
            int count = in.read(buffer);
            if (count == -1) {
                break;
            }
            out.write(buffer, 0, count);
        }
        in.close();
        out.close();
    }
}
