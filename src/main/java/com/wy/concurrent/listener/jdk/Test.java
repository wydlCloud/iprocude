package com.wy.concurrent.listener.jdk;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname
 * @Description TODO
 * @Date 2020/4/1 10:11 下午
 */

public class Test {
    public static void main(String[] args) {
        DoorManager doorManager=new DoorManager();
        // 添加监听器
        doorManager.addDoorListener(new FrontDoorListener());
        doorManager.addDoorListener(new IDoorListener() {
            @Override
            public void dealDoorEvent(DoorEvent doorEvent) {
                if (doorEvent.getDoorState()!=null&&doorEvent.getDoorState().equals("open")){
                    System.out.println("后门打开警示灯亮起");
                }else {
                    System.out.println("后门关闭，警示灯熄灭");
                }
            }
        });
        // 模拟事件
        System.out.println("模拟打开门事件");
        // 事件源发生动作，这个时候就要通知监听器，有动作发生，并进行向监听器发送事件对象
        doorManager.fireOpend();
        System.out.println("模拟关闭门事件");
        // 创建事件对象
        DoorEvent doorEvent=new DoorEvent(doorManager);
        doorEvent.setDoorState("close");
        // 向监听器发送事件对象
        doorManager.notifyDoors(doorEvent);
    }
}
