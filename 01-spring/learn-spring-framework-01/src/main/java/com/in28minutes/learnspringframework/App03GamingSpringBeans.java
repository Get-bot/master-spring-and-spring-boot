package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.MarioGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {

        try ( AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
            context.getBean(GameRunner.class).run();
        }

    }
}
