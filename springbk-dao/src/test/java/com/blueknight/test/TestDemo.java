package com.blueknight.test;

import com.blueknight.dao.po.User;
import com.blueknight.mapper.UserMapper;
import com.blueknight.utils.BKUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liuyang on 2017/1/11.
 */

public class TestDemo {
    @Test
    public void test(){
        BKUtil.hello();
    }
}
