package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.common.enums.FlowerModuleEnum;
import com.example.entity.Account;
import com.example.entity.Find;
import com.example.entity.Flower;
import com.example.entity.User;
import com.example.mapper.FindMapper;
import com.example.mapper.FlowerMapper;
import com.example.mapper.UserMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 信息表招领业务处理
 **/
@Service
public class FindService {

    @Resource
    private FindMapper findMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private FlowerService flowerService;
    @Resource
    private  FlowerMapper flowerMapper;
    @Resource
    private  FindService findService;

    /**
     * 新增
     */
    public void add(Find find) {
        Account currentUser=TokenUtils.getCurrentUser();
        find.setUserId(currentUser.getId());
        find.setTime(DateUtil.format(new Date(),"yyyy-MM-dd"));
        findMapper.insert(find);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        findMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            findMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Find find) {
        findMapper.updateById(find);
    }

    /**
     * 根据ID查询
     */
    public Find selectById(Integer id) {
        Find find =findMapper.selectById(id);
        int flowerCount=flowerService.selectByFidAndModule(id, FlowerModuleEnum.FIND.getValue());
        find.setFlowerCount(flowerCount);
        return find;
    }

    /**
     * 查询所有
     */
    public List<Find> selectAll(Find find) {
        List<Find> list=findMapper.selectAll(find);
        for(Find find1: list)
        {
            int flowerCount=flowerMapper.selectByFidAndModule(find1.getId(), FlowerModuleEnum.FIND.getValue());
            find1.setFlowerCount(flowerCount);
            Flower userLike=flowerService.selectUserFlower(find1.getId(),FlowerModuleEnum.FIND.getValue());
            find1.setUserFlower(userLike!=null);
        }
        return list;
    }

    /**
     * 分页查询
     */
    public PageInfo<Find> selectPage(Find find, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Find> list = findService.selectAll(find);
        return PageInfo.of(list);

    }

    public List<Find> selectNew4() {
        List<Find> list = findMapper.selectNew4();
        for(Find find : list) {
            User user = userMapper.selectById(find.getUserId());
            if (ObjectUtil.isNotEmpty(user))
            {
                find.setUserName(user.getName());
            }
        }
        return list;
    }
}