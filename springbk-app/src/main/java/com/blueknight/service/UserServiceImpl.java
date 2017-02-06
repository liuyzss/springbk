package com.blueknight.service;

import com.blueknight.dao.po.User;
import com.blueknight.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    public static Logger logger = LoggerFactory.getLogger(UserService.class);
    //User接口
    @Autowired
    private UserMapper userMapper;

    public List<User> findUser() throws Exception {
        //调用mapper类中的selectByExample方法，如果传入类型为null，则表示无条件查找
        List<User> users = new ArrayList<User>();
        User user = userMapper.selectByPrimaryKey(1);

        users.add(user);
        logger.info("+++++{}{}", "TEST", "++++++++++");
        return users;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
    public void testInsert(Integer rollback) throws Exception {
        for (int i = 0; i < 3; i++) {

            System.out.println("#############插入的" + i + "条件记录");
            User user = new User();
            user.setUsername("liuy" + i);

            user.setAddress("test" + i);
            user.setBirthday(new Date());
            user.setSex("F");
            userMapper.insert(user);
        }

        if (null == rollback || 0 == rollback) {
            throw new Exception("rollback");
        }

    }

    public Integer add(User user) {
        return userMapper.insert(user);
    }
}