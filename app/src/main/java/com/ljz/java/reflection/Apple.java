package com.ljz.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Apple {

    private int price;

    private int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setPrice(5);
        System.out.println("Apple 111 Price:" + apple.getPrice());

        try {
            //获取类的 Class 对象实例
            Class clz = Class.forName("com.ljz.java.reflection.Apple");
//            Class clz = Apple.class;//这种方法只适合在编译前就知道操作的 Class。

            /**
             * 反射获取对象成员的字段值，getFields()和getDeclaredFields()用法区别
             * getFields()只能获取public的字段，包括父类的。
             * 而getDeclaredFields()只能获取自己声明的各种字段，包括public，protected，private。
             * 与获取类属性一样，当我们去获取类方法、类构造器时，如果要获取私有方法或私有构造器，则必须使用有 declared 关键字的方法。
             */
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }

            //获取方法的 Method 对象
            Method setpriceMethod = clz.getMethod("setPrice", int.class);

            /**
             * 第一种：通过 Class 对象的 newInstance() 方法。
             * 通过 Constructor 对象创建类对象可以选择特定构造方法，而通过 Class 对象则只能使用默认的无参数构造方法。下面的代码就调用了一个有参数的构造方法进行了类对象的初始化。
             */
            //根据 Class 对象实例获取 Constructor 对象
            Constructor appleConstructor = clz.getConstructor();
            //使用 Constructor 对象的 newInstance 方法获取反射类对象
            Object appleObject = appleConstructor.newInstance();

            /**
             * 第二种：通过 Constructor 对象的 newInstance() 方法
             */
//            Apple appleObject = (Apple)clz.newInstance();

            //利用 invoke 方法调用方法
            setpriceMethod.invoke(appleObject, 8);

            Method getPriceMethod = clz.getDeclaredMethod("getPrice");
            System.out.println("Apple 222 Price:" + getPriceMethod.invoke(appleObject));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
