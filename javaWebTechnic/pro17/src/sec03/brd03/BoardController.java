package sec03.brd03;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

@WebServlet("/board3/*")
public class BoardController extends HttpServlet {

    private static String ARTICLE_IMAGE_REPO = "/Users/jaeheon/Desktop/Programming/webStudy/java-web-practice/pro17/article_image";
    BoardService boardService;
    ArticleVO articleVO;

    public void init(ServletConfig config) throws ServletException {
        boardService = new BoardService();
        articleVO = new ArticleVO();
    }

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
        String nextPage = "";
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo();

        try {
            List<ArticleVO> articlesList = new ArrayList<>();
            if (action == null) {
                articlesList = boardService.listArticles();
                request.setAttribute("articlesList", articlesList);
                nextPage = "/board02/listArticles.jsp";
            } else if (action.equals("/listArticles.do")) {
                articlesList = boardService.listArticles();
                request.setAttribute("articlesList", articlesList);
                nextPage = "/board02/listArticles.jsp";
            } else if (action.equals("/articleForm.do")) {
                nextPage = "/board02/articleForm.jsp";
            } else if (action.equals("/addArticle.do")) {
                int articleNO = 0;
                Map<String, String> articleMap = upload(request, response);
                String title = articleMap.get("title");
                String content = articleMap.get("content");
                String imageFileName = articleMap.get("imageFileName");
                articleVO.setParentNO(0);
                articleVO.setId("hong");
                articleVO.setTitle(title);
                articleVO.setContent(content);
                articleVO.setImageFileName(imageFileName);
                articleNO = boardService.addArticle(articleVO);

                if (imageFileName != null && imageFileName.length() != 0) {
                    File srcFile = new File(
                        ARTICLE_IMAGE_REPO + File.separator + "temp" + File.separator
                            + imageFileName);
                    File destDir = new File(ARTICLE_IMAGE_REPO + File.separator + articleNO);
                    destDir.mkdirs();
                    FileUtils.moveFileToDirectory(srcFile, destDir, true);
                }
                PrintWriter pw = response.getWriter();
                pw.print("<script>" + "  alert('새글을 추가했습니다.');" + " location.href='"
                    + request.getContextPath() + "/board/listArticles.do';" + "</script>");

                return;
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Map<String, String> articleMap = new HashMap<>();
        String encoding = "utf-8";
        //파일 객체를 생성
        File currentDirPath = new File(ARTICLE_IMAGE_REPO);
        //파일 업로드 처리를 위한 설정을 담당하는 DiskFileItemFactory 객체 생성
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(currentDirPath);
        factory.setSizeThreshold(1024 * 1024);

        //ServletFileUpload 객체를 생성해서 실제 파일 업로드 처리
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            //요청을 파싱해서 업로드된 아이템의 리스트를 얻어옴
            List items = upload.parseRequest(request);
            //리스트의 각 아이템을 순회하면서 FileItem으로 캐스팅
            for (int i = 0; i < items.size(); i++) {
                FileItem fileItem = (FileItem) items.get(i);
                //아이템이 일반 폼일 경우
                if (fileItem.isFormField()) {
                    System.out.println(
                        fileItem.getFieldName() + "=" + fileItem.getString(encoding));
                    articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
                } else { //아이템이 파일인 경우
                    System.out.println("파라미터 이름: " + fileItem.getFieldName());
                    System.out.println("파일 이름: " + fileItem.getName());
                    System.out.println("파일 크기: " + fileItem.getSize() + "bytes");

                    if (fileItem.getSize() > 0) {
                        int idx = fileItem.getName().lastIndexOf("\\");
                        if (idx == -1) {
                            idx = fileItem.getName().lastIndexOf("/");
                        }

                        //파일 이름을 추출
                        String fileName = fileItem.getName().substring(idx + 1);
                        articleMap.put(fileItem.getFieldName(), fileName);
                        //업로드할 파일의 전체 경로 생성
                        File uploadFile = new File(
                            currentDirPath + File.separator + "temp" + File.separator + fileName);
                        //파일을 디스크에 저장
                        fileItem.write(uploadFile);
                    }
                }
            }

            System.out.println(articleMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleMap;
    }
}
