package practice;

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

    Connection conn;
    PreparedStatement pstmt;
    DataSource factory;

    public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            factory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //회원 정보들을 출력하는 함수
    public List<MemberVO> listMembers() {
        List<MemberVO> membersList = new ArrayList<>();

        try {
            conn = factory.getConnection();
            String query = "SELECT * FROM t_member ORDER BY joinDate DESC";
            System.out.println("실행한 SQL문은 다음과 같습니다: " + query);
            pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");

                MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
                membersList.add(memberVO);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return membersList;
    }

    public void addMember(MemberVO vo) {
        try {
            conn = factory.getConnection();
            String id = vo.getId();
            String pwd = vo.getPwd();
            String name = vo.getName();
            String email = vo.getEmail();
            String query = "INSERT INTO t_member(id, pwd, name, email) VALUES(?, ? ,? ,?)";
            System.out.println("실행한 SQL문은 다음과 같습니다: " + query);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MemberVO findMember(String _id) {
        MemberVO memInfo = null;
        try {
            conn = factory.getConnection();
            String query = "SELECT * FROM t_member WHERE id=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, _id);
            System.out.println("실행한 SQL문은 다음과 같습니다: " + query);
            ResultSet rs = pstmt.executeQuery();

            rs.next();
            String id = rs.getString("id");
            String pwd = rs.getString("pwd");
            String name = rs.getString("name");
            String email = rs.getString("email");
            Date joinDate = rs.getDate("joinDate");
            memInfo = new MemberVO(id, pwd, name, email, joinDate);

            conn.close();
            pstmt.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return memInfo;
    }

    public void modifyMember(MemberVO vo) {
        try {
            conn = factory.getConnection();
            String id = vo.getId();
            String pwd = vo.getPwd();
            String name = vo.getName();
            String email = vo.getEmail();

            String query = "UPDATE t_member SET pwd=?, name=?, email=? WHERE id=?";
            System.out.println("실행한 SQL문은 다음과 같습니다: " + query);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, pwd);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delMember(String id) {
        try {
            conn = factory.getConnection();
            String query = "DELETE t_member WHERE id=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
