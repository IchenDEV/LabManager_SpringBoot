package com.idevlab.LabMgr.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "com.idevlab.LabMgr.Controller")
public class SysException {
    /**
     *
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> errorResult() {
        Map<String, Object> err = new HashMap<String, Object>();
        err.put("errCode", "500");
        err.put("msg", "RuntimeException");
        return err;

    }

}