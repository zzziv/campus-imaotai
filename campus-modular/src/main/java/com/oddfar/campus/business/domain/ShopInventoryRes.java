package com.oddfar.campus.business.domain;

import lombok.Data;

/**
 * 门店商品存量响应对象
 *
 * @author Elsen 2023/8/25
 */
@Data
public class ShopInventoryRes {


    /**
     * 我店id
     */
    private String iShopId;

    /**
     * 商品code
     */
    private String itemCode;

    /**
     * 省份
     */
    private String provinceName;

    /**
     * 城市
     */
    private String cityName;

    /**
     * 地区
     */
    private String districtName;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 完整地址
     */
    private String fullAddress;

    /**
     * 租户名称
     */
    private String tenantName;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品内容描述
     */
    private String content;

    /**
     * 商品图片
     */
    private String picture;

    /**
     * 最大储备数量
     */
    private Integer maxReserveCount;

    /**
     * 默认储备数量
     */
    private Integer defaultReserveCount;
}
