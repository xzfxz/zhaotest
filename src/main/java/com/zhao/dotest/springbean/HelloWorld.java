package com.zhao.dotest.springbean;

/**
 * Created by zhao on 2016/4/22.
 */
public class HelloWorld {
    public void say(){
        System.out.println("say() "+this.hashCode());
    }
    public void hello(){
        System.out.println("hello() "+this.hashCode());
    }
}
