package com.zhao.dotest.nutz;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Param;

/**
 * Created by zhao on 2016/5/9.
 */
@Modules(scanPackage = true)
@Encoding(input = "utf-8",output = "utf-8")
@At("/dotest")
public class MainModules {
    @At("/test01")
    public String dotest(@Param("name") String name){
    System.out.println(name);
    return name;
    }
}
