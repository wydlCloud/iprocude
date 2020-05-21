package com.wy.factoryTransfer.pojo;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname
 * @Description
 * @Date 2020/5/21 5:39 下午
 */
public class Result {

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
