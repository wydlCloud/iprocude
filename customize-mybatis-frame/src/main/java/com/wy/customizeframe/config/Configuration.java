package com.wy.customizeframe.config;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

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

     //map集合key:statementId value:MappedStatement
    private Map<String,MappedStatement> mappedStatementMap=new HashMap<String,MappedStatement>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }
}
