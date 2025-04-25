package com.hooniegit.SpringInitializer.MSSQL;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Sample MSSQL Source Config
 */
@Configuration
public class MultiDataSourceConfig {

    /**
     * Create DataSource Bean - Based on Config.ini Properties
     * * Url Name Should Be 'jdbc-url'
     * @return
     */
    @Bean(name = "tagDataSource")
    @ConfigurationProperties(prefix = "datasource.tag")
    public DataSource groupDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * Create Jdbc Template
     * @param ds
     * @return
     */
    @Bean(name = "tagJdbcTemplate")
    public JdbcTemplate groupJdbcTemplate(@Qualifier("tagDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

}

