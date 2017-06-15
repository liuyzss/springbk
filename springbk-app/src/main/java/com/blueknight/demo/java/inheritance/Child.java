package com.blueknight.demo.java.inheritance;

/**
 * Created by liuyang on 2017/3/23.
 */
public class Child extends Parent{
    private String extName;

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public static void main(String[] args){
        Parent p = new Child();
        System.out.println(p.getClass());
        System.out.println(p instanceof Parent);
        System.out.println(p instanceof Child);
        System.out.println(p instanceof Snow);
    }
}
