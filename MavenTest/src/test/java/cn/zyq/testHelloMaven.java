package cn.zyq;

import org.junit.Assert;
import org.junit.Test;

public class testHelloMaven {
    @Test
    public void testAddNumber(){
        helloMaven helloMaven = new helloMaven();
        int result = helloMaven.addNumber(10, 20);
        System.out.println(result);
        Assert.assertEquals(30,result);
    }
}
