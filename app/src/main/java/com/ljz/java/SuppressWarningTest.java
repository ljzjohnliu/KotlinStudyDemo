package com.ljz.java;

import java.util.Date;

public class SuppressWarningTest {

    /**
     * SuppressWarnings 常用的关键字的表格
     * <p>
     * deprecation  -- 使用了不赞成使用的类或方法时的警告
     * unchecked    -- 执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型。
     * fallthrough  -- 当 Switch 程序块直接通往下一种情况而没有 Break 时的警告。
     * path         -- 在类路径、源文件路径等中有不存在的路径时的警告。
     * serial       -- 当在可序列化的类上缺少 serialVersionUID 定义时的警告。
     * finally      -- 任何 finally 子句不能正常完成时的警告。
     * all          -- 关于以上所有情况的警告。
     */
    @SuppressWarnings(value = {"deprecation"})
    public static void doSomething() {
        Date date = new Date(113, 8, 26);
        System.out.println(date);
        int type = 0;
        switch (type) {
            case 0:
                System.out.println("type is 0");
            case 1:
            default:
        }
    }

    public static void main(String[] args) {
        doSomething();
    }
}
