package practice.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {

    BoardDAO boardDAO;

    BoardService() {
        boardDAO = new BoardDAO();
    }

    public Map listArticles(Map<String, Integer> map) {
        Map articlesMap = new HashMap();
        List<ArticleVO> articlesList = boardDAO.selectAllArticles(map);
        int totalArticles = boardDAO.selectTotalArticles();
        articlesMap.put("articlesList", articlesList);
        articlesMap.put("totArticles", totalArticles);
        return articlesMap;
    }
}
