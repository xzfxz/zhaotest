package com.zhao.dotest.springbean;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhao on 2016/4/22.
 */
public class Dotest {
    ApplicationContext context =null;
    @Before
    public void test00(){
        context = new ClassPathXmlApplicationContext("application-test.xml");
    }
    @Test
    public void test01(){
        HelloWorld helloworld = (HelloWorld) context.getBean("helloWorld");
        helloworld.hello();

    }
}
