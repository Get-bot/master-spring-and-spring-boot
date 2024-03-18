package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};
record Address (String firstLine, String City){};

//스프링 설정 클래스
@Configuration
public class HelloWorldConfiguration {
    //스프링 Bean 정의
    @Bean
    public String name() {
        return "nameBean";
    }

    @Bean
    public int age() {
        return 30;
    }

    @Bean
    public Person person() {
        return new Person("personA", 20, new Address("Main Street", "Inchon"));
    }

    // 기존 Spring Bean 과 연결된 Bean
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    // 파라미터로 설정
    @Bean
    public Person person3Parameters(String name, int age, Address address2) {//name, age, address
        return new Person(name, age, address2);
    }

    //address3 가 없기 때문에 기본 bean을 가져옴
    @Bean
    public Person person4Parameters(String name, int age, Address address3) {//name, age, address
        return new Person(name, age, address3);
    }

    //@Qualifier("address3qualifier") 한정자 사용
    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {//name, age, address
        return new Person(name, age, address);
    }

    @Bean()
    @Primary
    public Address address() {
        return new Address("Baker Street", "London");
    }

    //qualifier사용
    @Bean
    @Qualifier("address3qualifier")
    public Address address2() {
        return new Address("미추홀", "인천");
    }


}
