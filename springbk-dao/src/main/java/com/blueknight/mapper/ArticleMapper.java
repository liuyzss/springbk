package com.blueknight.mapper;

import com.blueknight.dao.po.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    int batchInsertSelective(@Param("list") List<Article> list);

    int batchInsert(@Param("list") List<Article> list);
}