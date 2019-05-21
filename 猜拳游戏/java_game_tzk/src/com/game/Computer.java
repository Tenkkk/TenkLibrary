package com.game;

public class Computer {
    String name;  //电脑姓名
    int scores;  //电脑累计得分

    //引用random方法达到电脑随机出拳的效果
    public int showFist() {
        String way = "";
        int i = (int) ((Math.random() * 3) + 1);   //random控制范围在1~3
        if (i == 1) {
            way = "剪刀";
        } else if (i == 2) {
            way = "石头";
        } else if (i == 3) {
            way = "布";
        }
        System.out.println(name + "出：" + way);
        return i;  //将random随机产生的数字作返回值返回出去，用来和用户输入的数字进行比较
    }
}
