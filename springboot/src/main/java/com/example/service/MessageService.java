package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.common.enums.TypeEnum;
import com.example.entity.*;
import com.example.mapper.FindMapper;
import com.example.mapper.LostMapper;
import com.example.mapper.MessageMapper;
import com.example.mapper.UserMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 留言信息表业务处理
 **/
@Service
public class MessageService {

    @Resource
    private MessageMapper messageMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private LostMapper lostMapper;
    @Resource
    private FindMapper findMapper;

    /**
     * 新增
     */
    public void add(Message message) {
        message.setTime(DateUtil.now());
        messageMapper.insert(message);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        messageMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            messageMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Message message) {
        messageMapper.updateById(message);
    }

    /**
     * 根据ID查询
     */
    public Message selectById(Integer id) {
        return messageMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Message> selectAll(Message message) {
        return messageMapper.selectAll(message);
    }

    /**
     * 分页查询
     */
    public PageInfo<Message> selectPage(Message message, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Message> list = messageMapper.selectAll(message);
        for(Message dbMessage: list)
        {
                User fromUser=userMapper.selectById(dbMessage.getFromId());
                User toUser=userMapper.selectById(dbMessage.getToId());
                dbMessage.setFromName(fromUser.getName());
                dbMessage.setToName(toUser.getName());
                //通过type来区分是从那个广场来的信息
            if(TypeEnum.LOST.type.equals(dbMessage.getType()))
            {
                Lost lost=lostMapper.selectById(dbMessage.getArticleId());
                if(ObjectUtil.isNotEmpty(lost))
                {
                    dbMessage.setArticleName(lost.getName());
                    dbMessage.setArticleImg(lost.getImg());
                }

                }
            else{
                Find find=findMapper.selectById(dbMessage.getArticleId());
                if(ObjectUtil.isNotEmpty(find))
                {
                    dbMessage.setArticleName(find.getName());
                    dbMessage.setArticleImg(find.getImg());
                }

            }
        }
        return PageInfo.of(list);
    }

}