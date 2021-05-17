package me.nglow.data.postgres;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
@Profile("postgres")
public class PostgresRunner implements ApplicationRunner {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public PostgresRunner(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()) {
            System.out.println(dataSource.getClass());
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
            String sql = "DROP TABLE ACCOUNT;";
            statement.executeUpdate(sql);
            sql = "CREATE TABLE ACCOUNT(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id));";
            statement.executeUpdate(sql);
        }

        // 위 방법보다 JDBC 템플릿을 사용하는것을 추천 -> Connection관리등 여러가지를 처리해주는듯...
        jdbcTemplate.execute("INSERT INTO ACCOUNT VALUES (1, 'taekhyeon')");
    }
}
