package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        //1: 스프링 컨텍스트 실행 -

        //JVM 내에 스프링 컨텍스트 생성
        try ( AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            //2: 스프링 프레임워크가 설정 관리 - @Configuration
            //HelloWorldConfiguration - @Configuration
            // name - @Bean

            //3: Spring이 관리하는 Bean 검색
            System.out.println("name = " + context.getBean("name"));
            System.out.println("age = " + context.getBean("age"));
            System.out.println("person = " + context.getBean("person"));
            System.out.println("person2 = " + context.getBean("person2MethodCall"));
            System.out.println("person3 = " + context.getBean("person3Parameters"));
            System.out.println("address = " + context.getBean("address"));
            System.out.println("address = " + context.getBean("address3qualifier"));
            //클래스를 사용하여 검색
            //System.out.println("context.getBean(Address.class) = " + context.getBean(Address.class));

            //모든 spring bean 확인
            String[] beanDefinitionNames = context.getBeanDefinitionNames();
            Arrays.stream(beanDefinitionNames).forEach(name -> System.out.println(name + " = " + context.getBean(name)));

        }




    }
}

