package com.spring.ex01;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        ApplicationContext context = new ClassPathXmlApplicationContext("AOPTest.xml");
        Calculator cal = (Calculator) context.getBean("proxyCal");
        cal.add(100, 20);
        System.out.println();
        cal.subtract(100, 20);
        System.out.println();
        cal.multiply(100, 20);
        System.out.println();
        cal.divide(100, 20);
    }
}
