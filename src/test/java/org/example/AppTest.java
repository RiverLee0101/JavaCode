package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public void foo(int value) {
        value = 100;
        System.out.println("value：" +value);
    }

    public void toFalse(boolean tag) {
        tag = false;
        System.out.println(tag);
    }

    public void foo(String text) {
        text = "windows";
        System.out.println(text);
    }

    public void foo(StringBuilder builder) {
        builder.append("4");
    }

    /**
     * 测试 值传递 和 引用传递
     * num = 10,经过foo赋值以后,值没变
     */
    @Test
    public void testPass() {
        // 基本类型
        int num = 10;
        foo(num);
        System.out.println("num：" +num);

        // 基本类型
        boolean tag = true;
        toFalse(tag);
        System.out.println(tag);

        // 没有提供改变自身方法的引用类型
        String str = "hello";
        foo(str);
        System.out.println(str);

        // 提供了改变自身方法的引用类型
        StringBuilder sb = new StringBuilder("iphone");
        foo(sb);
        System.out.println(sb);
    }

    @Test
    public void testGit(){
        //....
        // test
    }
}
