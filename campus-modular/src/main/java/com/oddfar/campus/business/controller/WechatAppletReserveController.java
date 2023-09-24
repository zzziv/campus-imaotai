package com.oddfar.campus.business.controller;

import com.oddfar.campus.business.service.IWechatAppletReserveService;
import com.oddfar.campus.common.annotation.ApiResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.management.remote.JMXPrincipal;

/**
 * 微信小程序余悦茅台API
 *
 * @author Elsen 2023/9/24
 */
@RestController
@RequestMapping("/wechat/applet")
@ApiResource(name = "微信小程序预约茅台")
public class WechatAppletReserveController {

    @Resource
    private IWechatAppletReserveService wechatAppletReserveService;

}
