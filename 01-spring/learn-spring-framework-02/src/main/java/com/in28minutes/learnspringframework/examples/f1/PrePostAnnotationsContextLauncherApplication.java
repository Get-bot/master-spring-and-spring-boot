package com.in28minutes.learnspringframework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class someClass {
    private final SomeDependency someDependency;

    public someClass (SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready");
    }

    //의존성 연결후 PostConstruct 어노테이션이 붙은 메서드 호출
    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    //컨테이너에서 인스턴스를 삭제하는 과정 중에 있음을 알려주는 콜백 알림
    // 보유하고 있던 리소스를 해제하는 데 일반적으로 사용
    @PreDestroy
    public void cleaningUp() {
        System.out.println("Cleaning up");
    }

}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
    public static void main(String[] args) {

        try ( AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }

    }
}