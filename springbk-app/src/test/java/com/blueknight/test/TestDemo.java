package com.blueknight.test;

import com.blueknight.dao.po.User;
import com.blueknight.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by liuyang on 2017/1/11.
 */

@ContextConfiguration("classpath*:config/spring/applicationContext-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDemo {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
        //List<User> list = userMapper.select();
        //System.out.println(list);
    }

    @Test
    public void concurrentDelByUniq(){
        User user = new User();
        user.setStuNumber("123456");
        user.setUsername("liuyang");
        user.setBirthday(new Date());
        user.setSex("F");
        user.setAddress("奥森");
        userMapper.insert(user);
        int threadSize = 20;
        CountDownLatch startLock = new CountDownLatch(1);
        CountDownLatch endLock = new CountDownLatch(threadSize);

        ExecutorService executorService = Executors.newFixedThreadPool(threadSize);

        List<Future> futureList = new ArrayList<Future>();

        for (int i = 0; i < threadSize; i++) {

            Future task = executorService.submit(new Callable<Object>() {

                @Override
                public Object call() throws Exception {
                    startLock.await();
                    System.out.println("======开始======="+Thread.currentThread());
                    int re =  userMapper.delete(user.getStuNumber());
                    System.out.println("======结束======="+Thread.currentThread());
                    endLock.countDown();
                    return re;
                }
            });

        }

        System.out.println(userMapper.select(user.getStuNumber()));
        startLock.countDown();
        try {
            endLock.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
