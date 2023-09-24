package com.oddfar.campus.business.service;

/**
 * 微信小程序预约茅台接口
 *
 * @author Elsen 2023/9/24
 */
public interface IWechatAppletReserveService {

    /**
     * 添加小程序用户
     *
     * @param mobile 手机号
     */
    void addAppletUser(String mobile);


    /**
     * 开始预约
     */
    void reserve();

    /**
     * 预约结果
     */
    void reserveResult();

}
