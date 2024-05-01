package com.example.mapper;

import com.example.entity.Flower;
import org.apache.ibatis.annotations.Param;

public interface FlowerMapper {
    void insert(Flower flower);

    Flower selectUserFlower(Flower flower);

    void deleteById(Integer id);

    int selectByFidAndModule(@Param("fid") Integer fid,@Param("module") String module);
}
