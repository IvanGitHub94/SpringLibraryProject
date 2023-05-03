/*package com.jpcsaturday.SpringLibraryProject.dbexample;

import com.jpcsaturday.SpringLibraryProject.dbexample.dao.BookDAOBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import static com.jpcsaturday.SpringLibraryProject.dbexample.constants.DBConstants.*;


@Configuration
@ComponentScan
//@ComponentScan(value = {"com.jpcsaturday.SpringLibraryProject.dbexample.dao"})
public class MyDBConfigContext {

    private final Environment env;

    public MyDBConfigContext(Environment env) {
        this.env = env;
    }

    @Bean
    @Scope("singleton")
    public Connection newConnection() throws SQLException {
        return DriverManager.getConnection(
                Objects.requireNonNull(env.getProperty("spring.datasource.url")),
                env.getProperty("spring.datasource.username"),
                env.getProperty("spring.datasource.password")
        );
    }

//    @Bean
//    public BookDAOBean bookDAOBean() throws SQLException {
//        return new BookDAOBean(newConnection());
//    }

}*/

