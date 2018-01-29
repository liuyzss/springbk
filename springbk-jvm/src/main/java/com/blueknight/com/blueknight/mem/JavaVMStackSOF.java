package com.blueknight.com.blueknight.mem;

/**
 * Created by liuyang on 2017/9/11.
 * -Xss128k
 * -Xss128k:设置每个线程的堆栈大小
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        String a = "";
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Exception e) {
            System.out.println("Stack Length:"+javaVMStackSOF.stackLength);
            e.printStackTrace();
        }
    }
}
