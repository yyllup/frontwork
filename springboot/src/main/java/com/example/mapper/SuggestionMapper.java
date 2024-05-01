package com.example.mapper;

import com.example.entity.Suggestion;

import java.util.List;

/**
 * 操作suggestion相关数据接口
*/
public interface SuggestionMapper {

    /**
      * 新增
    */
    int insert(Suggestion suggestion);

    /**
      * 删除
    */
    int deleteById(Integer id);

    /**
      * 修改
    */
    int updateById(Suggestion suggestion);

    /**
      * 根据ID查询
    */
    Suggestion selectById(Integer id);

    /**
      * 查询所有
    */
    List<Suggestion> selectAll(Suggestion suggestion);

}