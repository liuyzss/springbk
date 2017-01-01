package com.blueknight.service;

import com.blueknight.dao.po.User;
import com.blueknight.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    //User接口
    @Autowired
    private UserMapper userMapper;

    public List<User> findUser() throws Exception {
        //调用mapper类中的selectByExample方法，如果传入类型为null，则表示无条件查找
        List<User> users = userMapper.select();

        return users;
    }
    @Transactional
    public void testInsert(){
       for(int i=0;i<1;i++) {

           System.out.println("#############插入的"+i+"条件记录");
           User user = new User();
           user.setUsername("liuy"+i);

           userMapper.insert(user);
       }

    }
}