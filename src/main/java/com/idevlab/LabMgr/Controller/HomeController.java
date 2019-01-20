package com.idevlab.LabMgr.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @RequestMapping("/index")
    public String index(int i) {
        int j = 1 / i;
        String x="hello";
        return x + j;
    }
  

}