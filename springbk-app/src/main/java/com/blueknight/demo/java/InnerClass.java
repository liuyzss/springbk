package com.blueknight.demo.java;

/**
 * Created by liuyang on 2017/3/21.
 */
public class InnerClass {
    public static void main(String args[]){
        Student s1 = new Student("s1");
        Student s2 = new Student("s2");

        Student.Teacher tt = new Student.Teacher();

        Student.Teacher t1 = s1.getTeacher();
        t1.name = "s1";
        Student.Teacher t2 = s2.getTeacher();
        t2.name = "s2";
        t1.age = "s1";
        t2.age = "s2";
        System.out.println(t1.name);
        System.out.println(t1.age);
    }

}
