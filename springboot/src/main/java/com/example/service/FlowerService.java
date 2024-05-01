package com.example.service;

import com.example.entity.Account;
import com.example.entity.Flower;
import com.example.mapper.FlowerMapper;
import com.example.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 功能:送花功能操作接口
 * 日期： 2024/3/9 14:36
 */
@Service
public class FlowerService {
    @Resource
    FlowerMapper flowerMapper;

    public void set(Flower flower) {
        Account currentUser= TokenUtils.getCurrentUser();
        flower.setUserId(currentUser.getId());
       Flower dbFlower= flowerMapper.selectUserFlower(flower);
        if(dbFlower == null){

            flowerMapper.insert(flower);
        }
        else
        {
            flowerMapper.deleteById(dbFlower.getId());
        }


    }
    public Flower selectUserFlower(Integer fid,String module)
    {
        Account currentUser= TokenUtils.getCurrentUser();
        Flower flower =new Flower();
        flower.setUserId(currentUser.getId());
        flower.setFid(fid);
        flower.setModule(module);
        return flowerMapper.selectUserFlower(flower);
    }

    public int selectByFidAndModule(Integer fid, String module) {

        return flowerMapper.selectByFidAndModule(fid,module);
    }
}