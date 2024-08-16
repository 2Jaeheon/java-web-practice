package sec02.ex01;

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

    public boolean isExisted(MemberVO memberVO) {
        boolean result = false;

        String id = memberVO.getId();
        String pwd = memberVO.getPwd();
        try {
            con = dataFactory.getConnection();
            // decode(count(*), 1, 'true', 'false')는 오라클의 DECODE 함수로,
            // 첫 번째 인자인 count(*)가 1이면 'true'를 반환하고,
            // 그렇지 않으면 'false'를 반환합니다.
            String query = "SELECT decode(count(*), 1, 'true', 'false') AS RESULT FROM t_member";
            query += " WHERE id=? and pwd=?";

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            ResultSet rs = pstmt.executeQuery();
            //커서를 첫 번째 레코드로 위치시킵니다.
            rs.next();
            result = Boolean.parseBoolean(rs.getString("result"));
            System.out.println("result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MemberVO> listMembers(MemberVO memberVO) {
        List<MemberVO> list = new ArrayList<MemberVO>();
        //조회할 이름을 가져옴
        String _name = memberVO.getName();
        try {
            con = dataFactory.getConnection();
            String query = "select * from t_member";
            //_name값이 존재하면 SQL문에 where절을 추가해서 해당 이름으로 조회
            if (_name != null && _name.length() != 0) {
                query += " where name = ?";
                pstmt = con.prepareStatement(query);
                //첫 번째 ? 에 전달된 이름을 지정
                pstmt.setString(1, _name);
            } else {
                //_name값이 없으면 모든 회원 정보를 조회함
                pstmt = con.prepareStatement(query);
            }

            System.out.println("prepareStatement: " + query);
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
}
