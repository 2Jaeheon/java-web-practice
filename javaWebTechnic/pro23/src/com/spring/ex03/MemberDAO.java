package com.spring.ex03;

import com.spring.ex01.MemberVO;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {

    private static SqlSessionFactory sqlMapper = null;

    private static SqlSessionFactory getInstance() {
        if (sqlMapper == null) {
            try {
                String resource = "mybatis/SqlMapConfig.xml";
                Reader reader = Resources.getResourceAsReader(resource);
                sqlMapper = new SqlSessionFactoryBuilder().build(reader);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sqlMapper;
    }

    public List<MemberVO> selectAllMemberList() {
        sqlMapper = getInstance();
        //실제 member.xml의 SQL문을 호출하는데 사용되는 SqlSession 객체를 가져옴
        SqlSession session = sqlMapper.openSession();
        List<MemberVO> memlist = null;
        //여러 개의 레코드를 조회하므로 selectList() 메서드에 실행하고자 하는 SQL문의 id를 인자로 전달합니다.
        //List<HashMap<String, String>> memlist = null;
        memlist = session.selectList("mapper.member.selectAllMemberList");
        return memlist;
    }

    public String selectName() {
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        String name = session.selectOne("mapper.member.selectName");
        return name;
    }

    public int selectPwd() {
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        int pwd = session.selectOne("mapper.member.selectPwd");
        return pwd;
    }

    public MemberVO selectMemberById(String id) {
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        //서블릿에서 넘어온 id의 값을 selectOne()메소드 호출 시 해당 SQL문의 조건 값으로 전달
        MemberVO memberVO = session.selectOne("mapper.member.selectMemberById", id);
        return memberVO;
    }

    public List<MemberVO> selectMemberByPwd(String pwd) {
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        List<MemberVO> membersList = null;
        membersList = session.selectList("mapper.member.selectMemberByPwd", pwd);
        return membersList;
    }
}
