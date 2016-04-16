package com.zhao.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2016/4/11.
 */
public class JavaBase64 {
    public static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    public static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    public static String base64StringToImage(String base64String){
        String url = null;
        String realPath="D:\\zhao";
        File file = new File(realPath,"banner");
        if(!file.exists()){
                file.mkdirs();
        }
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File(file,UUID.randomUUID().toString()+".png");//可以是jpg,png,gif格式
            if(!w2.exists()){
                w2.createNewFile();
            }
            ImageIO.write(bi1, "jpg", w2);//不管输出什么格式图片，此处不需改动
            url = w2.getAbsolutePath();
            System.out.println(url);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
        public  static String getImageBinary(){
            File f = new File("d://1.jpg");
            BufferedImage bi;
            try {
                bi = ImageIO.read(f);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bi, "jpg", baos);
                byte[] bytes = baos.toByteArray();

                return encoder.encodeBuffer(bytes).trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
       }
    }
