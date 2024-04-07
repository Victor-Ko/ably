package com.victor.ably.test;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@Component
public class TestRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Connection connection = dataSource.getConnection();
        log.info("Url: " + connection.getMetaData().getURL());
        log.info("UserName: " + connection.getMetaData().getUserName());

        // JdbcTemplate
        //jdbcTemplate.execute("INSERT INTO TB_MEMBER (email, name) values ('dwadwad', 'dadw')");
    }
}
