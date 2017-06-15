package com.blueknight.demo.java;

/**
 * Created by liuyang on 2017/3/5.
 */
public class Student {
    String name;
    public static String age;
    public Student(String name){
        this.name = name;
    }

    public static class Teacher{
        public static String name;
        public String age;
        public static void test(){
            String s1 = Student.age;
        }
    }

    class TeacherOther{
        public String age;
        public  void test(){
        }
    }
    public Teacher getTeacher(){
        return new Teacher();
    }
}
