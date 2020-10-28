package com.company;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

/**
 * @description:
 * @author: Mask
 * @time: 2020/10/15 4:01 下午
 */
public class test {

    public static void main(String[] args) {
        String a = "10";
        func(a);
        System.out.println("main重新赋值后的a：" + a);

        Person person = new Person();
        person.setName("张三");

        PersonCrossTest(person);
        System.out.println("main重新赋值后的name：" + person.getName());
    }

    public static void func(String a) {
        System.out.println("传入的a：" + a);
        a = "20";
        System.out.println("方法内重新赋值后的a:" + a);
    }

    public static void func2(String[] b) {

    }

    public static void PersonCrossTest(Person person) {
        System.out.println("传入的person的name：" + person.getName());
        person.setName("我是李四");
        System.out.println("方法内重新赋值后的name：" + person.getName());
    }


}

class Person {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
