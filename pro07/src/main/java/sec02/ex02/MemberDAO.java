package sec02.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
    /*
     * private static final String driver = "oracle.jdbc.driver.OracleDriver"; private static final
     * String url = "jdbc:oracle:thin:@localhost:1521:XE"; private static final String user =
     * "scott"; private static final String pwd = "tiger";
     */
    private PreparedStatement pstmt;
    private Connection con;
    private DataSource dataFactory;

    public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MemberVO> listMembers() {
        List<MemberVO> list = new ArrayList<MemberVO>();
        try {
            // connDB();
            con = dataFactory.getConnection();
            String query = "select * from t_member";
            System.out.println("preparedStatement: " + query);
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");

                MemberVO vo = new MemberVO();
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                list.add(vo);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    // DAO에서 직접 데이터베이스 연결하는 기능 주석처
    /*
     * private void connDB() { try { Class.forName(driver);
     * System.out.println("oracle driver connection succescc"); con =
     * DriverManager.getConnection(url, user, pwd); System.out.println("Connection success"); }
     * catch (Exception e) { e.printStackTrace(); } }
     */
    public void addMember(MemberVO memberVO) {
        try {
            // DB랑 연결
            con = dataFactory.getConnection();
            // 테이블에 저장할 회원정보 가지고옴
            String id = memberVO.getId();
            String pwd = memberVO.getPwd();
            String name = memberVO.getName();
            String email = memberVO.getEmail();

            // insert 를 문자열로 만듬
            String query = "insert into t_member";
            query += "(id, pwd, name, email)";
            query += "values(?, ?, ?, ?)";
            System.out.println("prepareStatement: " + query);

            pstmt = con.prepareStatement(query);
            // insert 문의 각 ?의 순서대로 회원정보 세팅
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            // 회원정보를 테이블에 추가
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delMember(String id) {
        try {
            con = dataFactory.getConnection();
            String query = "delete from t_member" + " where id = ?";
            System.out.println("prepareStatememt:" + query);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

