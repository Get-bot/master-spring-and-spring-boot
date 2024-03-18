package com.in28minutes.learnspringframework.game;

public class GameRunner {

    //강한 결합 사용
    // private final MarioGame game;

    //인터페이스를 통한 느슨한 결합
    private final GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
}

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
