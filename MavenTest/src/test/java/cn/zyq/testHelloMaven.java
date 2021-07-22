package cn.zyq;

import org.junit.Assert;
import org.junit.Test;

public class testHelloMaven {
    @Test
    public void test1(){
        System.out.println("test111111111");
        helloMaven hm = new helloMaven();
        int result = hm.addNumber(10, 20);
        Assert.assertEquals(30,result);
    }
    @Test
    public void test2(){
        System.out.println("test22222222");
        helloMaven hm = new helloMaven();
        int result = hm.addNumber(10, 20);
        Assert.assertEquals(3,result);
    }
}
