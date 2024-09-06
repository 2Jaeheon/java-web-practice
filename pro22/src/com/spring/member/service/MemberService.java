package com.spring.member.service;


import com.spring.member.vo.MemberVO;
import java.util.List;
import org.springframework.dao.DataAccessException;

public interface MemberService {

    public List listMembers() throws DataAccessException;

    public int addMember(MemberVO memberVO) throws DataAccessException;
}