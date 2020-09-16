package com.ljz.java;

import static com.ljz.java.Color.BLUE;

enum Color {
    RED, GREEN, BLUE;

    // 构造函数
    private Color() {
        System.out.println("Constructor called for : " + this.toString());
    }

    public void colorInfo() {
        System.out.println("Universal Color");
    }
}

public class Test {

    public static void main(String[] args) {
        Color c1 = BLUE;
        System.out.println(c1);
        switch (c1) {
            case RED:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
        }

        for (Color myVar : Color.values()) {
            System.out.println(myVar);
        }

        // 调用 values()
        Color arr[] = Color.values();

        // 迭代枚举
        for (Color col : arr) {
            // 查看索引
            System.out.println(col + " at index " + col.ordinal());
        }

        // 使用 valueOf() 返回枚举常量，不存在的会报错 IllegalArgumentException
        System.out.println(Color.valueOf("RED"));
//        System.out.println(Color.valueOf("WHITE"));
    }
}
