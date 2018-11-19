package com.baiyun.luke.optimal.admin.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class LoginController {


    @RequestMapping("/login")
    @ResponseBody
    public com.baiyun.common.Utils.JsonResponse login(){
        com.baiyun.common.Utils.JsonResponse response = new com.baiyun.common.Utils.JsonResponse();


        response.setRetCode(com.baiyun.common.constant.Constant.SUCCESS_CODE);
        response.setRetMsg(com.baiyun.common.constant.Constant.SUCCESS_MSG);
        return response;
    }

}
