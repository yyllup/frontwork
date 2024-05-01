package com.example.controller;

import com.example.common.Result;
import com.example.entity.Suggestion;
import com.example.service.SuggestionService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 建议信息前端操作接口
 **/
@RestController
@RequestMapping("/suggestion")
public class SuggestionController {

    @Resource
    private SuggestionService suggestionService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Suggestion suggestion) {
        suggestionService.add(suggestion);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        suggestionService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        suggestionService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Suggestion suggestion) {
        suggestionService.updateById(suggestion);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Suggestion suggestion = suggestionService.selectById(id);
        return Result.success(suggestion);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Suggestion suggestion ) {
        List<Suggestion> list = suggestionService.selectAll(suggestion);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Suggestion suggestion,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Suggestion> page = suggestionService.selectPage(suggestion, pageNum, pageSize);
        return Result.success(page);
    }

}