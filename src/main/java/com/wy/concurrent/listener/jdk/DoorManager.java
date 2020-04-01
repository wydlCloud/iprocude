package com.wy.concurrent.listener.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname DoorManager
 * @Description 事件源实体类
 * @Date 2020/4/1 10:06 下午
 */

public class DoorManager {
    private List<IDoorListener> listenerList=new ArrayList<>();
    // 事件源中添加事件监听器方法
    public void  addDoorListener(IDoorListener listener){
        synchronized (this){
            if (listener!=null&&!(listenerList.contains(listener))){
                listenerList.add(listener);
            }
        }
    }
    // 事件源中删除监听器方法
    private void removeIDoorListener(IDoorListener listener){
        synchronized (this){
            if (listenerList.contains(listener)){
                listenerList.remove(listener);
            }
        }
    }
    // 向监听器发送事件对象，调用监听器处理事件的方法，进行处理事件对象
    // 这个其实就是向监听器发送事件对象的方法
    public void notifyDoors(DoorEvent event){
        for (IDoorListener iDoorListener:listenerList){
            iDoorListener.dealDoorEvent(event);
        }
    }

    /**
     * 模拟打开门事件
     * 如果有动作发送，向监听器发送事件对象
     */
    public void fireOpend(){
        if (listenerList==null){
            return;
        }
        // 创建事件对象，向监听器发送事件对象
        DoorEvent event=new DoorEvent(this);
        event.setDoorState("open");
        notifyDoors(event);
    }
}
