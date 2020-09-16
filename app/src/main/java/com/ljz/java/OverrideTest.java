package com.ljz.java;

public class OverrideTest {

    /**
     * toString() 在java.lang.Object中定义;
     * 因此，这里用 @Override 标注是对的
     */
    @Override
    public String toString() {
        return "Override toString";
    }

    /**
     * getString() 没有在 OverrideTest 的任何父类中定义;
     * 但是，在这里却用 @Override 标注，因此会产生编译错误！
     */
//    @Override
    public String getString() {
        return "get String";
    }

    public static void main(String[] args) {

    }
}
