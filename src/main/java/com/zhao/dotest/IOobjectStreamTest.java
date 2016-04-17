package com.zhao.dotest;

import com.zhao.entity.Employee;
import org.junit.Test;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhao on 2016/4/17.
 */
public class IOobjectStreamTest {

    @Test
    public void testFileChannel() throws IOException {
        Path path = Paths.get("D:\\zhao.test");
        FileChannel channel = FileChannel.open(path,StandardOpenOption.READ);
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);

        if(buffer.hasRemaining()){
            char aChar = buffer.getChar();
            System.out.println(aChar);
        }

    }

    /***
     * 在处理文件长度较大时，还必须用2进制文件流
     * Files.newInputStream(path);
     * Flies.newBufferWriter(path,default);
     * @throws IOException
     */
    @Test
    public void testFilesRead() throws IOException {
        Path path =Paths.get("D:\\zhao.test");
        byte[] bytes = Files.readAllBytes(path);
        System.out.println("---->");
        String content = new String(bytes, Charset.defaultCharset());
        System.out.println(content);

        List<String> strings = Files.readAllLines(path,Charset.defaultCharset());
        System.out.println(strings);
    }
    @Test
    public void testPathFilesWrite() throws IOException {
        Path path = Paths.get("D:\\", "zhao.test");
        Path fileName = path.getFileName();
//        byte[] bytes = new byte[]{'a','b','c'};
        String content;
//        content = new String(bytes, Charset.defaultCharset());
        content = new String("this is zhao do test");
        Files.write(path,content.getBytes(Charset.defaultCharset()), StandardOpenOption.APPEND);


    }
    @Test
    public void test01() throws FileNotFoundException {
        Employee zhao = new Employee("zhao",1,22.22,new Date(System.currentTimeMillis()));
        Employee tom = new Employee("tom",2,33.33,new Date(System.currentTimeMillis()));
        Employee jerry = new Employee("jerry",4,44.44,new Date(System.currentTimeMillis()));
        List<Employee> list = new ArrayList<Employee>();
        list.add(zhao);
        list.add(tom);
        list.add(jerry);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.data"));
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.data"));
            List<Employee> emps = (List<Employee>) ois.readObject();

            Employee employee = emps.get(1);
            employee.setSalary(55.55);

            for (Employee emp :emps){
                System.out.println(emp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
