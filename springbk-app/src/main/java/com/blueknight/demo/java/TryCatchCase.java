package com.blueknight.demo.java;

/**
 * Created by liuyang on 2017/3/5.
 */
public class TryCatchCase {
    public static int tryIntegerCase() {
        int a = 0;
        try {
            a = 1;
            int b = 1 / 0;
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            a = 2;
            return a;
        } finally {
            a = 3;
        }
    }

    public static int demo(int a){
        a = 3;
        return a;
    }

    //    public static Student tryStudentCase(){
//        Student s = new Student();   //student就是一个简单的model类，不再列出了
//        try{
//            s.setId(1);
//            int b= 1/0;
//            return s;
//        }catch(Exception e){
//            e.printStackTrace();
//            s.setId(2);
//            return s;
//        }finally{
//            s.setId(3);
//        }
//    }
    public static void main(String[] args) {
        int a = tryIntegerCase();
        System.out.println(a);
        //Student s = tryStudentCase();
        //System.out.println(s.getId());
        int test = 2;
        System.out.println(TryCatchCase.demo(test));
        System.out.println(test);
    }
}
