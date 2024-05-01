package com.example.controller;

import com.example.common.Result;
import com.example.entity.Flower;
import com.example.service.FlowerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 功能
 * 作者：程序员唐雅玲
 * 日期： 2024/3/9 14:35
 */
@RestController
@RequestMapping("/flower")
public class FlowerController {
    @Resource
    FlowerService flowerService;
    //送花功能和取消送花功能是一起的
    @PostMapping("/set")
    public Result set(@RequestBody Flower flower)
    {
            flowerService.set(flower);
     return Result.success();
    }

}