package org.zerock.jdbcex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lombok.Cleanup;
import org.zerock.jdbcex.domain.TodoVO;

public class TodoDAO {

    //try-with-resources문을 사용한 DB 사용
    public String getTime() {
        String now = null;

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT now()");
            ResultSet resultSet = preparedStatement.executeQuery();) {
            resultSet.next();
            //resultSet 의 행 번호는 1번부터 저장
            now = resultSet.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return now;
    }

    //Cleanup 애너테이션을 사용한 DB사용
    public String getTime2() throws Exception {
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("SELECT NOW()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        //resultSet의 행 번호는 1번부터 저장
        String now = resultSet.getString(1);
        return now;
    }

    //데이터 추가
    public void insert(TodoVO vo) throws Exception {
        String sql = "INSERT INTO tbl_todo (title, dueDate, finished) VALUES (?, ?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, vo.getTitle());
        preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
        preparedStatement.setBoolean(3, vo.isFinished());
        preparedStatement.executeUpdate();
    }

    //테이블 전체 조회
    public List<TodoVO> selectAll() throws Exception {

        String sql = "SELECT * FROM tbl_todo";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<TodoVO> list = new ArrayList<>();

        while (resultSet.next()) {
            TodoVO vo = TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();

            list.add(vo);
        }

        return list;
    }

    //선택한 행의 데이터 조회
    public TodoVO selectOne(Long tno) throws Exception {
        String sql = "SELECT * FROM tbl_todo WHERE tno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        TodoVO vo = TodoVO.builder()
            .tno(resultSet.getLong("tno"))
            .title(resultSet.getString("title"))
            .dueDate(resultSet.getDate("dueDate").toLocalDate())
            .finished(resultSet.getBoolean("finished"))
            .build();

        return vo;
    }

    //선택한 행의 정보 수정(title, dueDate, finished)
    public void updateOne(TodoVO todoVO) throws Exception {
        String sql = "UPDATE tbl_todo set title = ?, dueDate = ?, finished = ? WHERE tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, todoVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(todoVO.getDueDate()));
        preparedStatement.setBoolean(3, todoVO.isFinished());
        preparedStatement.setLong(4, todoVO.getTno());

        preparedStatement.executeUpdate();
    }
}
