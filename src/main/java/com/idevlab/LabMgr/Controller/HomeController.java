package com.idevlab.LabMgr.Controller;

import com.idevlab.LabMgr.Entity.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @RequestMapping("/index")
    public String index(int i) {
        int j = 1 / i;
        return "success " + j;
    }

    @RequestMapping("/lombok")
    public String lombok(int i) {
        User u = new User();
        u.setAge(18);
        u.setName("23");
     return u.toString();
    }

}