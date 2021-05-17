package com.sqx.controller;

import com.sqx.pojo.User;
import com.sqx.service.UserService;
import com.sqx.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/loginController")
public class LoginController {

    UserService userService = new UserServiceImpl();

    @Autowired
    @Qualifier("UserServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest req){
        List<User> userList = userService.getUserList();

        String username = req.getParameter("username");
        String pwd = req.getParameter("password");

        if(username == null || pwd == null){
            //TODO
        }

        for (User user : userList) {
            if(user.getUsername().equals(username) && user.getPassword().equals(pwd)){
                return "OK";
            }
        }
        return "ERROR";
    }


}
