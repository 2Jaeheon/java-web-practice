package com.spring.member.dao;

import com.spring.member.vo.MemberVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDAOImpl implements MemberDAO {

    private JdbcTemplate jdbcTemplate;

    //설정 파일에서 생성한 dataSource 빈을 setter를 이용해서 JdbcTemplate 클래스 생성자의 인자로 입력합니다.
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List selectAllMembers() throws DataAccessException {
        String query =
            "SELECT id, pwd, name, email, joinDate " + "FROM t_member " + "ORDER BY joinDate DESC";

        // jdbcTemplate 클래스의 query 메서드 인자로 SELECT 문을 전달해 조회한 레코드 개수만큼
        // MemberVO 개게를 생성합니다. 각 레코드의 값들 속성에 저장하고 다시 membersList 로 전달
        List membersList = new ArrayList();
        membersList = this.jdbcTemplate.query(query, new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                MemberVO memberVO = new MemberVO();
                memberVO.setId(rs.getString("id"));
                memberVO.setPwd(rs.getString("pwd"));
                memberVO.setName(rs.getString("name"));
                memberVO.setEmail(rs.getString("email"));
                memberVO.setJoinDate(rs.getDate("joinDate"));
                return memberVO;
            }
        });

        return membersList;
    }

    @Override
    public int addMember(MemberVO memberVO) throws DataAccessException {
        String id = memberVO.getId();
        String pwd = memberVO.getPwd();
        String name = memberVO.getName();
        String email = memberVO.getEmail();
        String query = "INSERT INTO t_member(id, pwd, name, email) VALUES ("
            + "'" + id + "' ,"
            + "'" + pwd + "' ,"
            + "'" + name + "' ,"
            + "'" + email + "') ";
        System.out.println(query);

        int result = jdbcTemplate.update(query);
        System.out.println(result);
        return result;
    }
}
