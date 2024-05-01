package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Constants;
import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户前端操作接口(接收前端页面传来信息）
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/add")
    Result add(@RequestBody User user){
        userService.add(user);
        return Result.success();
    }
    @PutMapping ("/update")
    Result update(@RequestBody User user)
    {
        userService.update(user);
        return Result.success();
    }

    @GetMapping("/selectPage")//分页查询
    Result selectPage(User user,@RequestParam Integer pageNum,@RequestParam Integer pageSize)
    {
        PageInfo<User> pageInfo=userService.selectPage(user,pageNum,pageSize);
        return Result.success(pageInfo);
    }
    @DeleteMapping("/delete/{id}")
    Result delete(@PathVariable Integer id)
    {
        userService.delete(id);
        return Result.success();
    }
    @DeleteMapping("delete/batch")
    Result deleteBatch(@RequestBody List <Integer> ids)
    {
        for(Integer id:ids)
        {
            userService.delete(id);
        }
        return Result.success();
    }


}