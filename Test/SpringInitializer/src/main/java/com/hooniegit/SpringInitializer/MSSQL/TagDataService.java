package com.hooniegit.SpringInitializer.MSSQL;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Sample MSSQL Service
 */
@Service
public class TagDataService {

    private final JdbcTemplate tagJdbcTemplate;

    public TagDataService(@Qualifier("tagJdbcTemplate") JdbcTemplate tagJdbcTemplate) {
        this.tagJdbcTemplate = tagJdbcTemplate;
    }

    /**
     * Sample Task :: SELECT Query
     */
    @PostConstruct
    public void testQuery() {
        Integer tagCount = tagJdbcTemplate.queryForObject("""
        SELECT COUNT(*) 
        FROM ctc_kafka.dbo.kf_tag;
        """, Integer.class);

        System.out.println("[TagCount] >>>>>>>> " + tagCount);
    }

}

