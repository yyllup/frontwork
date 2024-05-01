package com.example.mapper;

import com.example.entity.Lost;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作Lost相关数据接口
*/
public interface LostMapper {

    /**
      * 新增
    */
    int insert(Lost lost);

    /**
      * 删除
    */
    int deleteById(Integer id);

    /**
      * 修改
    */
    int updateById(Lost lost);

    /**
      * 根据ID查询
    */
    Lost selectById(Integer id);

    /**
      * 查询所有
    */
    List<Lost> selectAll(Lost lost);

    @Select("select * from lost where status='丢失中' order by id desc limit 4")
    List<Lost> selectNew4();
}