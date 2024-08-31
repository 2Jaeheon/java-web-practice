package practice.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

    private DataSource dataFactory;
    Connection conn;
    PreparedStatement pstmt;

    public BoardDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List selectAllArticles(Map pagingMap) {
        List articlesList = new ArrayList();
        int section = (Integer) pagingMap.get("section");
        int pageNum = (Integer) pagingMap.get("pageNum");

        try {
            conn = dataFactory.getConnection();
            String query = "SELECT * FROM ( " + "select ROWNUM  as recNum," + "LVL," + "articleNO,"
                + "parentNO," + "title," + "id," + "writeDate" + " from (select LEVEL as LVL, "
                + "articleNO," + "parentNO," + "title," + "id," + "writeDate" + " from t_board"
                + " START WITH  parentNO=0" + " CONNECT BY PRIOR articleNO = parentNO"
                + "  ORDER SIBLINGS BY articleNO DESC)" + ") "
                + " where recNum between(?-1)*100+(?-1)*10+1 and (?-1)*100+?*10";
            System.out.println(query);
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, section);
            pstmt.setInt(2, pageNum);
            pstmt.setInt(3, section);
            pstmt.setInt(4, pageNum);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int level = rs.getInt("lvl");
                int articleNO = rs.getInt("articleNO");
                int parentNO = rs.getInt("parentNO");
                String title = rs.getString("title");
                String id = rs.getString("id");
                Date writeDate = rs.getDate("writeDate");
                ArticleVO article = new ArticleVO();
                article.setLevel(level);
                article.setArticleNO(articleNO);
                article.setParentNO(parentNO);
                article.setTitle(title);
                article.setId(id);
                article.setWriteDate(writeDate);
                articlesList.add(article);
            } //end while
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articlesList;
    }


    public int selectTotalArticles() {
        try {
            conn = dataFactory.getConnection();
            String query = "select count(articleNO) from t_board ";
            System.out.println(query);
            pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return (rs.getInt(1));
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}