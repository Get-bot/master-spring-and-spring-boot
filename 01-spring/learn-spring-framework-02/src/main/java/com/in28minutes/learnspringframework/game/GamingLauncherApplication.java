package com.in28minutes.learnspringframework.game;

import com.in28minutes.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingLauncherApplication {
    public static void main(String[] args) {

        try ( AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingLauncherApplication.class)){
            context.getBean(GameRunner.class).run();
        }

    }
}