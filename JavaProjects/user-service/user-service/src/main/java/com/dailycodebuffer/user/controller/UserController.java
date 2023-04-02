package com.dailycodebuffer.user.controller;

import com.dailycodebuffer.user.VO.RestTemplateVO;

import com.dailycodebuffer.user.entity.EndUser;
import com.dailycodebuffer.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public EndUser saveUser(@RequestBody EndUser user){
      return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public RestTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
      return userService.getUserWithDepartment(userId);
    }

}
