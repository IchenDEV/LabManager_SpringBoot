package com.idevlab.LabMgr.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
@Value("${http_host}")
private String http_host;

    @RequestMapping("/index")
    public String index(int i) {
        int j = 1 / i;
        String x="hello";
        return x+http_host + j;
    }
    
    /**
     * @return the http_host
     */
    public String getHttp_host() {
        return http_host;
    }

}