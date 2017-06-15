package com.blueknight.demo.java.exception;

/**
 * Created by liuyang on 2017/3/24.
 */
public class FinallyDemo {
    public String demo(boolean flag){
        try{
            if(flag){
                throw new Exception();
            }
            try {
                System.out.println("start==================");
                throw new Exception();
            } catch (MyException e) {
                System.out.println("++++++++++++++myexception+++++++");
            }finally{
                System.out.println("++++++++++++++finally+++++++");
            }

        }catch(Exception e){
            System.out.println("++++++++++++++expception+++++++");
            return "inner return";
        }finally{
            System.out.println("++++++++++++++out finally+++++++");
        }
        System.out.println("++++++++++++++before return+++++++");
        return "out return";
    }
    public static void main(String[] args){
        FinallyDemo demo = new FinallyDemo();
        demo.demo(true);
    }

}
