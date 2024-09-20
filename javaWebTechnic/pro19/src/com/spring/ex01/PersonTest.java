package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

    public static void main(String[] args) {
        //PropertyConfigurator.configure("log4j.properties");
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("pro19/person.xml"));
        PersonService person = (PersonService) factory.getBean("personService3");
        //PersonService person = new PersonServiceImpl();
        person.sayHello();
    }
}
