package com.houserent;

import com.houserent.view.HouseView;

public class HouseRentApp {
    static void main(String[] args) {
        //创建HouseView对象，并且显示主菜单，程序入口
        /*HouseView houseView = new HouseView();
        houseView.mainMenu();*/
//或者匿名对象
        new HouseView().mainMenu();
    }
}
