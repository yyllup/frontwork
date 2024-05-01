package com.example.controller;

import com.example.common.Result;
import com.example.entity.Find;
import com.example.service.FindService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 招领信息表前端操作接口
 **/
@RestController
@RequestMapping("/find")
public class FindController {

    @Resource
    private FindService findService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Find find) {
        findService.add(find);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        findService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        findService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Find find) {
        findService.updateById(find);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Find find = findService.selectById(id);
        return Result.success(find);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Find find ) {
        List<Find> list = findService.selectAll(find);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Find find,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Find> page = findService.selectPage(find, pageNum, pageSize);
        return Result.success(page);
    }
    @GetMapping("/selectNew4")
    public Result selectNew4(){
        List<Find> list = findService.selectNew4();
        return Result.success(list);
    }

}