package org.zerock.jdbcex.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;


public enum ConnectionUtil {
    //객체를 하나만 생성할 수 있게해서 싱글톤패턴 구현
    INSTANCE;

    //Connection Pooling 데이터베이스 연결을 미리 생성하고 재사용함으로써 cost를 줄여줌
    //HikariConfig를 통해서 설정을 해준다음 이를 바탕으로 DataSource를 만들어줌
    private HikariDataSource ds;

    //ConnectionUtil를 생성할 때 DataSource 객체를 초기화시켜줌
    ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("1234");
        //동일한 SQL 구문을 재사용할 때, 해당 구문을 다시 컴파일할 필요 없이 캐시된 구문을 사용
        config.addDataSourceProperty("cachePrepStmts", "true");
        //repared Statements의 개수를 설정합니다. 여기서는 250개까지 캐시할 수 있도록 설정한 것
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        // SQL 구문의 최대 길이를 설정합니다. 여기서는 2048바이트까지의 SQL 구문만 캐시에 저장할 수 있음.
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
    }

    //다른 곳에서는 ConnectionUtil.INSTANCE.getConnection() 으로 사용하면 됨.
    public Connection getConnection() throws Exception {
        return ds.getConnection();
    }
}
