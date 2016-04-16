package com.zhao.dotest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by zhao on 2016/4/16.
 */
public class DoTestIO {
    @Test
    public void test01() throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        String property = System.getProperty("user.dir");
        System.out.println(property);
        byte[] bytes = new byte[1024];
        int b;
        while ((b=fis.read(bytes))!=-1){
            String result = new String(bytes,0,b);
            System.out.println(result);
        }
    }
}
