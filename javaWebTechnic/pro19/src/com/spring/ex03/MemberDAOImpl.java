package com.spring.ex03;

public class MemberDAOImpl implements MemberDAO {

    @Override
    public void listMembers() {
        System.out.println("listMembers() 메소드 호출");
        System.out.println("회원 정보를 조회합니다.");
    }

}
