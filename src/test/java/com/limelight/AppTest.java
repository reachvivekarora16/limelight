package com.limelight;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {


    @Test
    public void test(){
        String num ="0";
        if(num.matches("-?[1-9]\\d*|0")){
            System.out.println(num);
        }
    }

}
