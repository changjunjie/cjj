package com.coder.service.impl;

import com.coder.entity.User;
import com.coder.mapper.UserMapper;
import com.coder.retry.Retry;
import com.coder.service.IUserService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectById(User arg) {
        return null;
    }

    @Override
    @Retry(maxTimes = 3)
    public List<User> select(User arg) {
        return userMapper.select(arg);

    }

    @Override
    public User selectPaging(User arg) {
        return null;
    }

    @Override
    public User insert(User arg) {
        return null;
    }

    @Override
    public User insertSelective(User arg) {
        return null;
    }

    @Override
    public int update(User arg) {
        return userMapper.update(arg);
    }

    @Override
    public int updateSelective(User arg) {
        return userMapper.updateSelective(arg);
    }

    @Override
    public User delete(User arg) {
        return null;
    }

    @Override
    public User insertBatch(User arg) {
        return null;
    }

    @Override
    public User deletseBatch(User arg) {
        return null;
    }
}