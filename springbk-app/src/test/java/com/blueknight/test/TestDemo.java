package com.blueknight.test;

import com.blueknight.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}