package com.coder.web;

import com.alibaba.fastjson.JSON;
import com.coder.entity.User;
import com.coder.entity.base.WebRspEntity;
import com.coder.error.CodeEnum;
import com.coder.service.IUserService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final static Logger LOGGER = Logger.getLogger(UserController.class);

    @Resource
    IUserService iUserService;

    @RequestMapping("/loadUserList")
    public WebRspEntity loadUserList() {
        User user = new User();
        user.setId(1);
        List<User> users = iUserService.select(user);
        LOGGER.info(JSON.toJSONString(user));
        return new WebRspEntity(CodeEnum.SUCCESS, users);
    }

    @RequestMapping("/getUser")
    public void getUser() {
    }

    @RequestMapping("/addUser")
    public void addUser() {
    }

    @RequestMapping("/editUser")
    public void editUser() {
        User user = new User();
        user.setId(1);
        user.setAge(80);
        user.setName("zhangsan");
        iUserService.updateSelective(user);
    }

    @RequestMapping("/delUser")
    public void delUser() {
    }

}