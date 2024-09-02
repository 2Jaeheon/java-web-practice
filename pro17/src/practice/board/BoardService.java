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

    public int addArticle(ArticleVO article) {
        return boardDAO.insertNewArticle(article);
    }

    public ArticleVO viewArticle(int articleNO) {
        ArticleVO article = null;
        article = boardDAO.selectArticle(articleNO);
        return article;
    }

    public void modArticle(ArticleVO article) {
        boardDAO.updateArticle(article);
    }

    public List<Integer> removeArticle(int articleNO) {
        List<Integer> articleNOList = boardDAO.selectRemovedArticles(articleNO);
        boardDAO.deleteArticle(articleNO);
        return articleNOList;
    }

    public int addReply(ArticleVO article) {
        return boardDAO.insertNewArticle(article);
    }

}
