package com.blueknight.demo.java;

/**
 * Created by liuyang on 2017/3/5.
 */
public class Demo {
    String str = new String("good");
    char[] ch = {'a','b','b'};
    public void change(String str,char[] ch){
        str = "ok test";
        ch[0] = 'g';
    }

    public void test(String abc){
        abc = "ddddddd";
    }

    public void test2(Student stu){
        stu = new Student("aaa");
    }
    public static void main(String args[]){

        Demo d = new Demo();
        d.change(d.str,d.ch);
        System.out.println(d.str +"and");
        System.out.println(d.ch);
        String a = "abc";
        String b = "abc";
        String c = new String("abc");

        System.out.println(a==b);
        System.out.println(a==c);

        d.test(a);
        System.out.println(a);
        System.out.println(b);

        Student aaaa = new Student("cccc");
        d.test2(aaaa);
        System.out.println(aaaa.name);

    }
}
