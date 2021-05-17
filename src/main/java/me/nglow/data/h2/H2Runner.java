package me.nglow.data.h2;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
@Profile("h2")
public class H2Runner implements ApplicationRunner {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public H2Runner(DataSource dataSource, JdbcTemplate jdbcTemplate) {
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
            String sql = "DROP TABLE USER;";
            statement.executeUpdate(sql);
            sql = "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id));";
            statement.executeUpdate(sql);
        }

        // 위 방법보다 JDBC 템플릿을 사용하는것을 추천 -> Connection관리등 여러가지를 처리해주는듯...
        jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'taekhyeon')");
    }
}
