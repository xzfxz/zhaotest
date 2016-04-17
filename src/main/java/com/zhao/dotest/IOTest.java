package com.zhao.dotest;

import org.junit.Test;

import java.io.*;

/**
 * Created by zhao on 2016/4/16.
 */
public class IOTest {
    @Test
    public void test02() throws IOException {
        PushbackInputStream pushbackInputStream;
        pushbackInputStream = new PushbackInputStream(
                new BufferedInputStream(
                        new FileInputStream("a.txt")
                )
        );
        int read = pushbackInputStream.read();
        byte[] b = new byte[1024];
        int a;
        while ((a = pushbackInputStream.read(b))!=-1){
            if(read!='t'){
                pushbackInputStream.unread(read);
            }
            String s=new String(b,0,a);
            System.out.println(s);
        }

    }
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
