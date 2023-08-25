package com.oddfar.campus.business.domain;

import lombok.Data;

/**
 * i茅台预约商品信息
 */
@Data
public class IMTItemInfo {

    private String shopId;

    private int count;

    private String itemId;

    /**
     * 库存
     */
    private int inventory;

    /**
     * 马克斯储备数量
     */
    private Integer maxReserveCount;

    /**
     * 默认储备数量
     */
    private Integer defaultReserveCount;
}
