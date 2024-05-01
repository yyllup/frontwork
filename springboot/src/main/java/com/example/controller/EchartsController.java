package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Find;
import com.example.entity.Lost;
import com.example.service.FindService;
import com.example.service.LostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 功能
 * 作者：tyl
 * 日期： 2024/3/3 23:46
 */
@RequestMapping("/echarts")
@RestController



public class EchartsController {
    @Resource
    private LostService lostService;
    @Resource
    private FindService findService;
    @GetMapping("/all")
    public Result all(){
        //查询出所有失物广场的数量
        List<Lost> losts=lostService.selectAll(new Lost());
        //查询出所有招领广场的数据
        List<Find> finds=findService.selectAll(new Find());
        Map<String, Object> resultMap=new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        //往list里面塞业务数据
        Map<String,Object> lostMap=new HashMap<>();
        lostMap.put("name","平台发布失物总量");
        lostMap.put("value",losts.size());
        list.add(lostMap);
        Map<String,Object> findMap=new HashMap<>();
        findMap.put("name","平台发布招领总量");
        findMap.put("value",finds.size());
        list.add(findMap);
        resultMap.put("text","平台所有物品数量的统计");
        resultMap.put("subtext","统计范围：失物广场和招领广场");
        resultMap.put("name","总量");
        resultMap.put("data",list);
        return Result.success(resultMap);
    }
    @GetMapping("/lost")
    public Result lost()
    {
        //查询出所有失物广场的数量
        List<Lost> losts=lostService.selectAll(new Lost());
        //查询出所有招领广场的数据
        Map<String, Object> resultMap=new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        //往list封装数据
        //一步到位直接用stream流进行分类
        Map<String,Long> lostMap=losts.stream().filter(x-> ObjectUtil.isNotEmpty(x.getStatus()))
                        .collect(Collectors.groupingBy(Lost::getStatus,Collectors.counting()));
        //遍历lostMap里面的key
        for(String key:lostMap.keySet())
        {
            Map<String,Object> map=new HashMap<>();
            map.put("name",key);
            map.put("value",lostMap.get(key));
            list.add(map);
        }
        resultMap.put("name","总量");
        resultMap.put("text","失物广场物品数量的占比数据");
        resultMap.put("subtext","统计范围：丢失中和已找回");
        resultMap.put("data",list);


        return Result.success(resultMap);
    }
    @GetMapping("/find")
    public Result find()
    {
        //查询出所有失物广场的数量
        List<Find> finds=findService.selectAll(new Find());
        //查询出所有招领广场的数据
        Map<String, Object> resultMap=new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        //往list封装数据
        //一步到位直接用stream流进行分类
        Map<String,Long> findMap=finds.stream().filter(x-> ObjectUtil.isNotEmpty(x.getStatus()))
                .collect(Collectors.groupingBy(Find::getStatus,Collectors.counting()));
        //遍历lostMap里面的key
        for(String key:findMap.keySet())
        {
            Map<String,Object> map=new HashMap<>();
            map.put("name",key);
            map.put("value",findMap.get(key));
            list.add(map);
        }
        resultMap.put("name","总量");
        resultMap.put("text","招领广场物品数量的占比数据");
        resultMap.put("subtext","统计范围：已找到失主和未找到失主");
        resultMap.put("data",list);

        return Result.success(resultMap);
    }

}