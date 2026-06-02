package com.houserent.service;

import com.houserent.domain.House;
import com.houserent.utils.Utility;

/*
*
* //定义House[] 保存House对象
1.响应HouseView的调用
2.完成对房屋的信息的各种操作（crud）
*
* */
public class HouseService {
    private House[] houses; // 保存house对象，首先这个先声明 用的时候再给空间放
    private int houseNums;//从1开始(看作是房屋数组对象下标)
    private int idCounter;//id自增长

    //给个空构造器
    public HouseService() {
    }

    public HouseService(int size) {
        this.houses = new House[size];//分配空间
     /*   //test
        houses[0] = new House(1,"wan","122","山东省",2000,"未出租");
        houses[1] = new House(2,"wan","123","山东省",2000,"已出租");*/
    }
    //find方法
    public House find(int rind_id) {
        if (rind_id == 0 || rind_id > idCounter) {//id 是零或者大于等于idCounter不被允许
            return null;
        }
        for (int i = 0; i <houseNums; i++) {
            if (rind_id == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
     /*   int left = 0;
        int right = houseNums;//下标不用减一

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (houses[mid].getId() == rind_id) {
                return houses[mid];//找到了直接返回对象
            } else if (houses[mid].getId() < rind_id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null; // 没找到返回null*/
    }

    //houseAppExit方法返回一个bool值
    public boolean houseAppExit() {

        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            return false;
        }
        return true;
    }

    //
    //del方法删除一个房屋信息
    public boolean del(int delId) {
        //先找到要删除的房屋信息
        int index = -1;
        for (int i = 0; i < houseNums; i++) {//遍历已有的房屋数组编号
            if (delId == houses[i].getId()) {//查找
                index = i;//使用index记录i
            }
        }
        if (index == -1) {//说明要删除的id是不存在的(在数组中不存在怎么删除)
            return false;
        }
        //如果找到
        for (int i = index; i < houseNums - 1; i++) {//把目标+1的对象引用给目标 实现覆盖 继续覆盖之后的
            // 最后 houseNums-1 和houseNums-2 的对象引用是一个要把houseNums-1的对象置空
            // 和houseNums数值减一（因为我删除了一个房屋对象计数必须少一个但是id是不变的）
            houses[i] = houses[i + 1];
        }
        houses[--houseNums] = null;//最后一个元素置空，houseNums少了一个元素所以减一
        return true;
    }

    //add方法，添加新对象
    public boolean add(House newHouse) {
        //判断是否还可以继续添加
        if (houseNums == houses.length) {//数组已满不能添加 以后可以解决数组扩容问题
            //这里添加数组扩容
            houses = expand(houses);
        }
        houses[houseNums++] = newHouse;
        //id需要自增长 更新房屋id
        newHouse.setId(++idCounter);//newHouse引用仍然指向目标对象
        return true;
    }

    // 扩容方法，返回新的 House 数组
    public static House[] expand(House[] oldArray) {
        House[] newArray = new House[oldArray.length * 2]; // 长度翻倍
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i]; // 拷贝旧数组
        }
        return newArray;
    }

    //list方法返回所有房屋信息 各司其职这里只返回House数组对象 显示层在view
    public House[] list() {
        return houses;
    }

    public int getHousesArr() {
        return houses.length;
    }
}
