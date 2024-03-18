package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {

        var marioGame = new MarioGame(); // 객체 생성
        var gameRunner = new GameRunner(marioGame); // 객체 생성 + 의존성 연결
        gameRunner.run();

    }
}
