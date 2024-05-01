package com.example.mapper;

import com.example.entity.Find;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作Find相关数据接口
*/
public interface FindMapper {

    /**
      * 新增
    */
    int insert(Find find);

    /**
      * 删除
    */
    int deleteById(Integer id);

    /**
      * 修改
    */
    int updateById(Find find);

    /**
      * 根据ID查询
    */
    Find selectById(Integer id);

    /**
      * 查询所有
    */
    List<Find> selectAll(Find find);

    @Select("select * from find where status='未找到失主' order by id desc limit 4")
    List<Find> selectNew4();


}