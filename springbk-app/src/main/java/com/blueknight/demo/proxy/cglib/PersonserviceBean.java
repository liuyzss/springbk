package com.blueknight.demo.proxy.cglib;

import java.io.Serializable;

/**
 * Created by liuyang on 2017/10/25.
 */
public class PersonserviceBean implements Serializable {
    private transient String test;// = "TEST";
    private String user;
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
//    public PersonserviceBean() {
//        super();
//    }
//    public PersonserviceBean(String user) {
//        super();
//        this.user = user;
//    }
    public void save(Person person){
        System.out.println("执行PerServiceBean的save方法");
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
