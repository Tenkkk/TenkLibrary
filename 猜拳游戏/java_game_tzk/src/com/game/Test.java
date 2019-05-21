package com.game;

public class Test {
    public static void main(String[] args) {
        Game game = new Game();  //创建游戏对象   游戏中同时创建了 admin类 computer类的对象
        game.initial(); //开始标题菜单
        game.enemy(); //开始选择对战角色
        game.startGame();   //游戏本体
        game.showResult(); //显示最后结果
    }
}
