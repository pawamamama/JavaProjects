package com.houserent.view;

import com.houserent.service.HouseService;
import com.houserent.utils.Utility;

import com.houserent.domain.House;


/*
* 1.显示界面
2.接收用户输入
3调用其他类完成对房屋信息的各种操作
*
* */
public class HouseView {
    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接收用户输入
    private HouseService houseService = new HouseService(3);//创建了一个crud类的对象使用
    private int id = 0;
    String listPrintHouse = "编号\t房主\t电话\t地址\t月租\t状态（已出租/未出租）";

    //编写 reviseHouse()//修改房屋信息的功能
    public void reviseHouse(House house) {
        System.out.println("---------------请修改信息   回车默认不修改---------------");
        System.out.print("姓名：(" + house.getName() + ")：");
        house.setName(Utility.readString(5, house.getName()));
        System.out.print("电话(" + house.getPhone() + ")：");
        house.setPhone(Utility.readString(12, house.getPhone()));
        System.out.print("地址(" + house.getAddress() + ")：");
        house.setAddress(Utility.readString(15, house.getAddress()));
        System.out.print("月租("+house.getRent()+")：");
         house.setRent(Utility.readInt(house.getRent()));
        System.out.println("状态("+house.getState()+")：");
        house.setState(Utility.readString(3,house.getState()));
    }

    //编写findHouse(boolean control) control = false 查找房屋信息并输出房屋信息
    // or  control = true 调用true 调用reviseHouse方法修改信息
    public void findHouse(boolean control) {
        String findOrRevise = "查找";
        if (control) {
            findOrRevise = "修改";
        }
        System.out.println("---------------" + findOrRevise + "房屋---------------");
        System.out.print("请输入你要" + findOrRevise + "的房屋编号：");
        int rind = Utility.readInt();
        House house = houseService.find(rind);//找到了就会返回对象并且SetMid会设置好目标下标
        if (house == null) {
            System.out.println("---------------房屋编号 " + rind + " 未找到 请检查输入---------------");
            return;
        }
        //先执行执行查找复用一一下逻辑
        System.out.println("---------------查找到了编号为" + rind + "匹配的房屋对象信息---------------");
        System.out.println(listPrintHouse);
        System.out.println(house);//系统自动调用toString
        //复用代码逻辑
        if (control) {//这里true说明是修改进入revise进行修改
            reviseHouse(house);//获取到要修改的对象下标了开始进行修改
            return;
        }
        //control = false 不会进入修改逻辑
    }

    // 完成程序退出确认
    public void exit() {
        System.out.println("确定要退出吗");
        loop = houseService.houseAppExit();
        if (!loop) {
            System.out.println("---------------已退出程序---------------");
        }
    }

    //编写delHouse() 接收输入的id ，调用Service 的del方法
    public void delHouse() {
        System.out.println("---------------删除房屋信息---------------");
        System.out.print("请输入待删除的房屋编号（-1退出）：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("---------------放弃删除房屋信息---------------");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {//调用del方法
            if (houseService.del(delId)) {
                System.out.println("---------------删除了编号为" + delId + "的房屋信息---------------");
            } else {
                System.out.println("---------------编号为" + delId + "的房屋信息不存在删除失败---------------");
            }
        } else {
            System.out.println("---------------放弃删除房屋信息---------------");
        }


    }

    //编写addHouse()接收输入 ，创建House对象 ，调用add方法
    public void addHouse() {
        System.out.println("---------------添加房屋---------------");
        System.out.print("姓名：");
        String name = Utility.readString(5);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址");
        String address = Utility.readString(15);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.println("状态");
        String state = Utility.readString(3);
        //创建一个新的House对象 id是系统分配,用户不能输入,id在Service里分配这里先置成0
        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("---------------添加房屋成功房屋对象数组的值是" + houseService.getHousesArr() + "---------------");

        } else {

            System.out.println("---------------添加房屋失败---------------");
        }


    }


    //编写listHouse()显示房屋列表5
    public void listHouse() {
        //
        System.out.println("---------------房屋列表---------------");
        System.out.println(listPrintHouse);
        House[] houses = houseService.list();//使用list获取House数组对象
        //进行输出
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null) {//非空校验
                System.out.println(houses[i].toString());
            }

        }
        System.out.println("---------------房屋列表显示完毕---------------");

    }

    //显示一个主菜单
    public void mainMenu() {
        do {
            System.out.println("---------------房屋出租系统---------------");
            System.out.println("\t\t\t1 新 增 房 源 信 息");
            System.out.println("\t\t\t2 查 找 房 屋 信 息");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退       出");
            System.out.print("\t\t\t请输入你的选择（ 1 ~ 6 ）: ");
            char key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse(false);
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    findHouse(true);
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("输入的字符错误重新输入");
            }

        } while (loop);

    }


}
