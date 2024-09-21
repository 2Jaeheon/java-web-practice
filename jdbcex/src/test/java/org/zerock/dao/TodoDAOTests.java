package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    //BeforeEach를 이용하는 ready() 를 통해서 모든 테스트 전에 TodoDAO 타입의 객체를 생성하도록 함.
    //testTime()을 통해서 getTime()이 정상적으로 동작하는지 확인
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
    }
}
