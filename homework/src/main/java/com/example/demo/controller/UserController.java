package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/homework")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/add")
    public String add(String img,String title,String name,String des,String classify,Integer isdownload,String empower){
        userService.add(img, title, name, des, classify, isdownload, empower);
        return "添加成功";
    }
    @RequestMapping("/del")
    public String del(long id){
        userService.delect(id);
        return "删除成功";
    }
    @RequestMapping("/get")
    public User get(long id){
        User user = userService.get(id);
        return user;
    }
    @RequestMapping("/list")
    public List<User> lists(){
        List<User> users = userService.lists();
        return  users;
    }
    @RequestMapping("/up")
    public String up(long id,String img,String title,String name,String desc,String classify,Integer isdownload,String empower){
        User user=new User();
        user.setId(id);
        user.setImg(img);
        user.setTitle(title);
        user.setName(name);
        user.setDes(desc);
        user.setClassify(classify);
        user.setIsDownLoad(isdownload);
        user.setEmpower(empower);
        userService.up(user);
        return "更新成功";
    }

}