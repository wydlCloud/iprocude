package com.wy.other.listener.jdk;

import java.util.EventListener;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname IDoorListener
 * @Description 事件监听器
 * @Date 2020/4/1 8:59 下午
 */

public interface IDoorListener extends EventListener {
    // eventListener是所有事件侦听器接口必须扩展的标记接口，因为它是无内容的标记接口
    // 所有事件处理方法由我们自己声明
    public void dealDoorEvent(DoorEvent doorEvent);
}
