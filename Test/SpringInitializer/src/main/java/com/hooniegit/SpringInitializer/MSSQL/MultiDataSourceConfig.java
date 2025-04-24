package com.hooniegit.SpringInitializer.MSSQL;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MultiDataSourceConfig {

    // --- Tag DB 설정 ---
    @Value("${datasource.tag.url}")
    private String tagUrl;

    @Value("${datasource.tag.username}")
    private String tagUsername;

    @Value("${datasource.tag.password}")
    private String tagPassword;

    @Value("${datasource.tag.driver-class-name}")
    private String tagDriver;

    // --- Group DB 설정 ---
    @Value("${datasource.group.url}")
    private String groupUrl;

    @Value("${datasource.group.username}")
    private String groupUsername;

    @Value("${datasource.group.password}")
    private String groupPassword;

    @Value("${datasource.group.driver-class-name}")
    private String groupDriver;

    @Bean(name = "tagDataSource")
    public DataSource tagDataSource() {
        System.out.println("Tag DataSource URL: " + tagUrl);
        System.out.println("Tag DataSource Username: " + tagUsername);
        System.out.println("Tag DataSource Password: " + tagPassword);
        System.out.println("Tag DataSource Driver: " + tagDriver);

        return DataSourceBuilder.create()
                .url(tagUrl)
                .username(tagUsername)
                .password(tagPassword)
                .driverClassName(tagDriver)
                .build();
    }

    @Bean(name = "groupDataSource")
    public DataSource groupDataSource() {
        System.out.println("Group DataSource URL: " + groupUrl);
        System.out.println("Group DataSource Username: " + groupUsername);
        System.out.println("Group DataSource Password: " + groupPassword);
        System.out.println("Group DataSource Driver: " + groupDriver);

        return DataSourceBuilder.create()
                .url(groupUrl)
                .username(groupUsername)
                .password(groupPassword)
                .driverClassName(groupDriver)
                .build();
    }

    @Bean(name = "tagJdbcTemplate")
    public JdbcTemplate tagJdbcTemplate(@Qualifier("tagDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "groupJdbcTemplate")
    public JdbcTemplate groupJdbcTemplate(@Qualifier("groupDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

