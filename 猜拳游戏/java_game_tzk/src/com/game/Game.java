package com.game;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Admin admin = new Admin();//甲方玩家
    Computer computer = new Computer();//乙方
    int count = 0;  //记录轮数

    /**
     * 游戏开始前的标题菜单
     */
    public void initial() {
        System.out.println("--------------------欢迎进入沙雕大世界------------------------");
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t\t\t**************");
        System.out.println("\t\t\t\t\t**猜拳，开始**");
        System.out.println("\t\t\t\t\t**************");
        System.out.println();
        System.out.println();
        System.out.println("出拳规则：1.剪刀 2.石头 3.布");
    }

    /**
     * 紧接着用户选择自己想要对战的角色，并把选择的结果赋值给computer的name。
     */
    public void enemy() {
        System.out.print("请选择对战角色(1:马冬梅 \t2:马云 \t3:马化腾)：");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("你选择了 马冬梅 对战！");
                computer.name = "马冬梅";
                break;
            case 2:
                System.out.println("你选择了 马云 对战！");
                computer.name = "马云";
                break;
            case 3:
                System.out.println("你选择了 马化腾 对战！");
                computer.name = "马化腾";
                break;
        }
    }

    /**
     * 游戏本体
     */
    public void startGame() {
        System.out.print("请输入你的姓名：");   //用户输入自己的名字
        admin.name = scanner.next();           //admin类的name接受用户输入的名字
        System.out.println(admin.name + "\t\tVs\t\t" + computer.name); //小标题 用户的名字对战电脑的名字
        System.out.print("是否开始对战(输 y 开始)：");
        String start = scanner.next();
        if ("y".equals(start)) {    //判断是否真正开始游戏
            do {                 //开始游戏便进入循环
                System.out.print("请出拳 1.剪刀 2.石头 3.布（输入对应数字）：");//提示用户可以出什么
                int choice = scanner.nextInt();
                int x = admin.showFist(choice);   //调用用户出拳方法接收choice实参，并把返回值给到X。
                int y = computer.showFist();    //同理，调用电脑出拳方法的同时，返回值给Y。
                //判断 所有输赢情况
                if ((x == 1 && y == 1) || (x == 2 && y == 2) || (x == 3 && y == 3)) {
                    System.out.println("和局，真衰！嘿嘿，等着瞧吧！\n");
                } else if ((x == 2 && y == 1) || (x == 3 && y == 2) || (x == 1 && y == 3)) {
                    System.out.println("呀呼~！你赢了！\n");
                    admin.scores++;   //用户赢了  用户累计分数加一
                } else {
                    System.out.println("ヽ(°◇° )ノ，你输了，真笨\n");
                    computer.scores++;  //用户输了，电脑累计分数加一
                }
                count++;  //每轮判断结束，总轮数加一
                System.out.print("是否开始下一局(输 y 继续)：");
                start = scanner.next();
            } while ("y".equals(start));   //当用户选择y代表继续，则继续循环一轮。
            System.out.println("已退出");  //否则退出
        }
    }

    /**
     * 显示结果
     */
    public void showResult(){
        //游戏体结束 给出结果
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(admin.name + "\t\tVs\t\t" + computer.name);
        System.out.println("对战次数：" + count);
        System.out.println("\n姓名\t得分");
        System.out.println(admin.name + "\t" + admin.scores);
        System.out.println(computer.name + "\t" + computer.scores);
        //三元运算符套三元运算符，判断 结果是 谁输谁赢亦或平局
        String end = (admin.scores == computer.scores) ? ("平局") : ((admin.scores > computer.scores) ? ("你赢了!") : ("你输了!"));
        System.out.println("\n结果：" + end);
    }
}
