package com.wy.other.listener.jdk;

import java.util.EventObject;

/**
 * @author wy
 * @company 中国网络科技
 * @Classname DoorEvent
 * @Description 事件对象
 */

public class DoorEvent extends EventObject {
    private String doorState="";

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DoorEvent(Object source) {
        super(source);
    }

    public String getDoorState() {
        return doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }
}
