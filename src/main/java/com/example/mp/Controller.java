package com.example.mp;

import com.example.mp.entity.User;
import com.example.mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

    private UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("user",new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(User user,Model model){
        User user1 = userService.findByUsername(user.getUsername());
        if (user1.getPassword().equals(user.getPassword())){
            model.addAttribute("user",user1);
            return "index";
        }
        else {
            return "failed!";
        }
    }

}
