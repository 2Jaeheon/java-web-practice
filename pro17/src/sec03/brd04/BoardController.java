package sec03.brd04;

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

@WebServlet("/board4/*")
public class BoardController extends HttpServlet {

    //파일 저장할 경로 설정
    private static String ARTICLE_IMAGE_REPO = "/Users/jaeheon/Desktop/Programming/webStudy/java-web-practice/pro17/article_image";
    BoardService boardService;
    ArticleVO articleVO;

    //초기화
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
        //다음으로 가야할 페이지
        String nextPage = "";
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo();

        try {
            //게시판의 글을 저장할 리스트
            List<ArticleVO> articlesList = new ArrayList<>();

            if (action == null || action.equals("/listArticles.do")) {
                articlesList = boardService.listArticles();
                request.setAttribute("articlesList", articlesList);
                nextPage = "/board02/listArticles.jsp";


            } else if (action.equals("/articleForm.do")) { //리스트를 출력하는 창에서 회원가입 버튼을 눌렀을 때
                //다음 페이지를 articleForm.jsp로 설정
                nextPage = "/board02/articleForm.jsp";


            } else if (action.equals("/addArticle.do")) { //회원가입 창에서 입력한 정보 처리
                int articleNO = 0;
                //아티클 정보를 저장할 Map title과 content, imageFileName을 쌍으로 저장함.
                Map<String, String> articleMap = upload(request, response);

                String title = articleMap.get("title");
                String content = articleMap.get("content");
                String imageFileName = articleMap.get("imageFileName");

                //articleVO를 설정
                articleVO.setParentNO(0);
                articleVO.setId("hong");
                articleVO.setTitle(title);
                articleVO.setContent(content);
                articleVO.setImageFileName(imageFileName);

                //새로운 게시물을 추가
                articleNO = boardService.addArticle(articleVO);

                //파일이름이 null이 아니면서 길이가 0이 아닐때
                if (imageFileName != null && imageFileName.length() != 0) {
                    //소스 파일을 생성
                    File srcFile = new File(
                        ARTICLE_IMAGE_REPO + File.separator + "temp" + File.separator
                            + imageFileName);
                    //목적 디렉토리을 생성
                    File destDir = new File(ARTICLE_IMAGE_REPO + File.separator + articleNO);
                    //디렉토리 생성
                    destDir.mkdirs();
                    //파일을 srcFile을 destDir로 이동
                    FileUtils.moveFileToDirectory(srcFile, destDir, true);
                }
                PrintWriter pw = response.getWriter();
                pw.print("<script>" + "  alert('새글을 추가했습니다.');" + " location.href='"
                    + request.getContextPath() + "/board/listArticles.do';" + "</script>");
                return;


            } else if (action.equals("/viewArticle.do")) { //특정 게시물을 눌렀을 때
                //게시물 번호를 가져옴
                String articleNO = request.getParameter("articleNO");
                //Service를 거치고 DAO를 거쳐서 데이터베이스에서 특정 게시물 내용 가져옴
                articleVO = boardService.viewArticle(Integer.parseInt(articleNO));
                //가져온 아티클 객체를 request 객체에 바인딩
                request.setAttribute("article", articleVO);
                nextPage = "/board03/viewArticle.jsp";
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
