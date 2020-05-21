package com.wy.other.listener.jdk;

/**
 * @author wy
 * @company 中国网络科技
 * @Classname FrontDoorListener
 * @Description 事件监听器具体的实现类，处理事件对象
 */

public class FrontDoorListener implements IDoorListener {
    @Override
    public void dealDoorEvent(DoorEvent doorEvent) {
        if (doorEvent.getDoorState()!=null&&doorEvent.getDoorState().equals("open")){
            System.out.println("打开前门");
        } else {
            System.out.println("关闭前门");
        }
    }
}
