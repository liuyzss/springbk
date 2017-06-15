package com.blueknight.controller;

import com.blueknight.dao.po.Article;
import com.blueknight.mapper.ArticleMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyang on 2017/5/10.
 */
@Controller
@RequestMapping("/batch")
public class TestBatchController {

    @Resource
    private ArticleMapper articleMapper;

    @RequestMapping("/batchInsertSelective")
    @ResponseBody
    public Object batchInsertSelective(@RequestParam("count") int count) throws Exception {
        List<Article> articles = new ArrayList<Article>();
        for (int i = 0; i < count; i++) {
            Article art = new Article();
            art.setTitle(i+"title");
            art.setImg(i+"title");
            art.setContent(i + "contenta;sldfkjal;sdkfj;alsdkjfalksdjfl;aksdfjl;aksjdfl;aksjdflakjsdflkajsdl;fkjals;dkfjals;dkfjla;skdjfla;skjdfl;asjdfl;aksjdflajsdfl;kjasdlfjasldfjasldkfjal;sdjflaskdfjlaskdfjlasjdlfjldjsfl;asjdlfsj");
            articles.add(art);
        }
        Long cur = System.currentTimeMillis();
        articleMapper.batchInsertSelective(articles);
        Long first = System.currentTimeMillis();
        System.out.println("batchInsertSelective---耗时："+(first-cur)+"毫秒");
        articleMapper.batchInsert(articles);
        Long scend = System.currentTimeMillis();
        System.out.println("batchInsert---耗时："+(scend-first)+"毫秒");
        return null;
    }
}
