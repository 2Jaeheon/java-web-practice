package practice.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boards/*")
public class BoardController extends HttpServlet {

    BoardService boardService;
    ArticleVO articleVO;

    @Override
    public void init() throws ServletException {
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

            if (action == null || action.equals("/listArticles.do")) {
                String _section = request.getParameter("section");
                String _pageNum = request.getParameter("pageNum");

                int section = Integer.parseInt((_section == null) ? "1" : _section);
                int pageNum = Integer.parseInt((_pageNum == null) ? "1" : _pageNum);

                Map<String, Integer> pagingMap = new HashMap<>();
                pagingMap.put("section", section);
                pagingMap.put("pageNum", pageNum);

                Map articlesMap = boardService.listArticles(pagingMap);
                articlesMap.put("section", section);
                articlesMap.put("pageNum", pageNum);

                request.setAttribute("articlesMap", articlesMap);
                nextPage = "/practice/boardPractice/listArticles.jsp";
            } else {
                nextPage = "/practice/boardPractice/listArticles.jsp";
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
