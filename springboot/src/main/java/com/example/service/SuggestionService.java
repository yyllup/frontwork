package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Account;
import com.example.entity.Suggestion;
import com.example.mapper.SuggestionMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 留言反馈业务处理
 **/
@Service
public class SuggestionService {

    @Resource
    private SuggestionMapper suggestionMapper;

    /**
     * 新增
     */
    public void add(Suggestion suggestion) {
        suggestion.setTime(DateUtil.now());
        suggestionMapper.insert(suggestion);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        suggestionMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            suggestionMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Suggestion suggestion) {
        suggestionMapper.updateById(suggestion);
    }

    /**
     * 根据ID查询
     */
    public Suggestion selectById(Integer id) {
        return suggestionMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Suggestion> selectAll(Suggestion suggestion) {
        return suggestionMapper.selectAll(suggestion);
    }

    /**
     * 分页查询
     */
    public PageInfo<Suggestion> selectPage(Suggestion suggestion, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Suggestion> list = suggestionMapper.selectAll(suggestion);
        return PageInfo.of(list);
    }

}