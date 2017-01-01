package com.blueknight.service;


import com.blueknight.dao.po.User;

import java.util.List;

/**
 * Created by liuyang on 16/7/31.
 */
public interface UserService {

    /**
     * 查找所有用户
     * @return
     * @throws Exception
     */
    List<User> findUser()throws Exception;
    public void testInsert();
}