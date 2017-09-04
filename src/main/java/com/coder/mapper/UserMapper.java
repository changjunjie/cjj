package com.coder.mapper;

import com.coder.entity.User;
import com.coder.mapper.base.IBaseMapper;
import com.coder.version.OptimisticLock;

public interface UserMapper extends IBaseMapper {

    @OptimisticLock(expect = 1)
    int updateSelective(User user);

}