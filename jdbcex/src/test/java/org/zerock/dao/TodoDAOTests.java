package org.zerock.dao;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

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

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder()
            .title("Sample Title...")
            .dueDate(LocalDate.of(2021, 12, 31))
            .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception {
        Long tno = 1L;
        TodoVO vo = todoDAO.selectOne(tno);
        System.out.println(vo);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO todoVO = TodoVO.builder()
            .tno(1L)
            .title("Sample Title...")
            .dueDate(LocalDate.of(2021, 12, 31))
            .finished(true)
            .build();

        todoDAO.updateOne(todoVO);
    }
}
