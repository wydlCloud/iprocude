package com.wy.other.type;

import lombok.Data;

/**
 * @Classname Message
 * @Description TODO
 * @Date 2020/9/23 2:17 下午
 * @Company
 * @Author yunze
 */
public class Message<T> {

    private T x ;
    private T y ;
    public void setX(T x) {
        this.x = (T) x;
    }
    public void setY(T y) {
        this.y = (T) y;
    }
    public T getX() {
        return this.x ;
    }
    public T getY() {
        return this.y ;
    }
}
