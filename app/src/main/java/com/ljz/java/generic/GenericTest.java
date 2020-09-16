package com.ljz.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 类型通配符一般是使用?代替具体的类型参数。例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。
 */
public class GenericTest {

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("ljz");
        age.add(20);
        number.add(3.14);
        getData(name);
        getData(age);
        getData(number);

//        getUperNumber(name);
        getUperNumber(age);
        getUperNumber(number);

//        getDownNumber(name);
//        getDownNumber(age);
        getDownNumber(number);
    }

    /**
     * 解析： 因为getData()方法的参数是List类型的，所以name，age，number都可以作为这个方法的实参，这就是通配符的作用
     * @param data
     */
    public static void getData(List<?> data) {
        System.out.println("data : " + data.get(0));
    }

    /**
     * 解析： 在(//1)处会出现错误，因为getUperNumber()方法中的参数已经限定了参数泛型上限为Number，所以泛型为String是不在这个范围之内，所以会报错
     * @param data
     */
    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data : " + data.get(0));
    }

    /**
     * 类型通配符下限通过形如 List<? super Number>来定义，表示类型只能接受Number及其三层父类类型，如 Object 类型的实例。
     * @param data
     */
    public static void getDownNumber(List<? super Number> data) {
        System.out.println("data : " + data.get(0));
    }
}
