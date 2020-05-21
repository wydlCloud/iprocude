package com.wy.dataStructure.array;

/**
 * @author wy
 * @company 中国网络科技
 * @Classname Array
 * @Description 手撸二次实现基本arrayList集合
 */

public class Array {
    private int[] data;
    private int size;

    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }
// 获取元素实际的大小
    public int getSize() {
        return size;
    }
// 获取容量的方法
    public int getCapacity() {
        return data.length;
    }

    // 往最后一位添加
    public void addLast(int e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("add Last fail");
//        }
//        data[size] = e;
//        size++;
        // 也可以这么去修改
        add(size, e);
    }

    // 往第一个添加
    public void addFirst(int e) {
//        if (size == 0) {
//            throw new IllegalArgumentException("add first fail");
//        }
//        data[0] = e;
//        size++;
        // 也可以这么去修改
        add(0, e);
    }

    // 指定索引位置添加
    public void add(int index, int e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("add data element fail");
        }
        if (size == data.length) {
            throw new IllegalArgumentException("add data element fail");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;

    }

    // 根据索引获取元素
    public int get(int index){
        return data[index];
    }
    // 修改数据
    public void update(int index,int e){
        // 校验数据的合法性
        if (index>size||index<0){
                throw new IllegalArgumentException("update data element fail");
        }
        data[index]=e;
    }

}
