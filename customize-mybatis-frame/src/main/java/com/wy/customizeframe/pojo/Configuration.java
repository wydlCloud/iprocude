package com.wy.customizeframe.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wy
 * @company
 * @Classname Configuration
 * @Description 数据源核心配置类
 * @Date 2020/5/12 12:20 上午
 */

public class Configuration {
    // 数据源
    private DataSource dataSource;

    //map集合key:statementId namespace+"."+id value:MappedStatement
    private ConcurrentHashMap<String, MapperStatement> mappedStatementMap = new ConcurrentHashMap<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MapperStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(ConcurrentHashMap<String, MapperStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }
}
