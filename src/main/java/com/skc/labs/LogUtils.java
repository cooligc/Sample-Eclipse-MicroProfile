package com.skc.labs;

import java.util.Date;

public class LogUtils {


    public static final void log(Object object){
        System.out.println(new Date() +"\t : \t"+object);
    }
}
