package sec03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
    private PreparedStatement pstmt;
    private Connection con;
    private DataSource factory;

    public DAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            factory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public List<VO> list() {
        List<VO> list = new ArrayList<VO>();
        try {
            con = factory.getConnection();
            String query = "SELECT * FROM t_member";
            System.out.println("preparedStatement: " + query);

            pstmt = con.prepareStatement(query);
            ResultSet set = pstmt.executeQuery();

            while (set.next()) {
                String id = set.getString("id");
                String pwd = set.getString("pwd");
                String name = set.getString("name");
                String email = set.getString("email");
                Date joinDate = set.getDate("joinDate");

                VO vo = new VO();
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);

                list.add(vo);
            }
            set.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addV(VO vo) {
        try {
            con = factory.getConnection();
            String id = vo.getId();
            String pwd = vo.getPwd();
            String name = vo.getName();
            String email = vo.getEmail();

            String query = "insert into t_member";
            query += "(id, pwd, name, email)";
            query += "values(?, ?, ?, ?)";
            System.out.println("Query: " + query);

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delV(String id) {
        try {
            con = factory.getConnection();
            String query = "DELETE FROM t_member ";
            query += "WHERE id=?";
            System.out.println("QUERY: " + query);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
