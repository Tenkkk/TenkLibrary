package com.game;

public class Admin {
    String name;  //用户输入的姓名
    int scores;  //用户累计得分

    //每轮用户出拳方法    引入形参
    public int showFist(int choice) {
        switch (choice) {
            case 1:
                System.out.println(name + "出：剪刀");
                break;
            case 2:
                System.out.println(name + "出：石头");
                break;
            case 3:
                System.out.println(name + "出：布");
                break;
        }
        return choice;  //返回引入的形参的整数，可以和电脑出拳进行比较
    }
}
