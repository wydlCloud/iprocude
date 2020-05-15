package com.wy.customizeframe.pojo;

/**
 * @author wy
 * @company
 * @Classname MappedStatement
 * @Description mapper.xml信息配置类
 * @Date 2020/5/12 12:22 上午
 */

public class MapperStatement {

    private String id;
    private String sql;
    private String paramterType;
    private String resultType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getParamterType() {
        return paramterType;
    }

    public void setParamterType(String paramterType) {
        this.paramterType = paramterType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
