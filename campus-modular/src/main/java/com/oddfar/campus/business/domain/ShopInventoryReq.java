package com.oddfar.campus.business.domain;

import lombok.Data;

/**
 * 门店商品存量请求对象
 *
 * @author Elsen 2023/8/25
 */
@Data
public class ShopInventoryReq {
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

    protected Integer pageNum = 1;
    protected Integer pageSize = 10;

    public Integer getPageNum() {
        return (pageNum - 1) * pageSize;
    }
}
