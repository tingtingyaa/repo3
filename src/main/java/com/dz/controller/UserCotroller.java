package com.dz.controller;

import com.dz.pojo.User;
import com.dz.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserCotroller {

    @Autowired
    private UserService userService;

    @RequestMapping("save")
    public String save(){
        User user = new User();
        user.setUserName("YingYing");
        user.setPassword("23456");
        userService.save(user);
        return "success";
    }

    //普通分页
    @RequestMapping("findByPage")
    @ResponseBody
    public List<User> findByPage(){
        return userService.findByPage();
    }

    //分页，显示所有关于分页的信息
    @RequestMapping("findUserByPage")
    @ResponseBody
    public PageInfo<User> findUserByPage(){
        return userService.findUserByPage();
    }


}
