package com.coder.service;

import com.coder.entity.User;
import java.util.List;

public interface IUserService {

    User selectById(User user);

    List<User> select(User user);

    User selectPaging(User user);

    User insert(User user);

    User insertSelective(User user);

    int update(User user);

    int updateSelective(User user);

    User delete(User user);

    User insertBatch(User user);

    User deletseBatch(User user);


}