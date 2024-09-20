package com.spring.ex01;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        //	ClassPathXmlApplicationContext는 클래스 경로에서 XML 설정 파일을 로드하는 데 사용됩니다.
        //	이는 설정 파일이 애플리케이션의 클래스 경로(즉, src/main/resources와 같은 디렉토리)에 위치할 때 주로 사용됩니다.

        //	FileSystemResource는 파일 시스템의 특정 경로에서 설정 파일을 로드할 때 사용됩니다.
        //	XmlBeanFactory는 XML 파일을 통해 스프링 빈을 정의하고 관리하는 스프링 컨테이너입니다.
        //	하지만 스프링 3.1 이후부터는 ApplicationContext가 더 권장되는 방식입니다.
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
