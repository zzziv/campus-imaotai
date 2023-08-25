package com.oddfar.campus.business.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * I茅台预约商品对象 i_item
 *
 * @author oddfar
 * @date 2023-07-02
 */
@Data
@TableName("i_shop_item_inventory")
public class IIShopItemInventory {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String itemId;

    /**
     * 商品ID
     */
    private String iShopId;

    /**
     * 商品code
     */
    private Integer inventory;

    /**
     * 马克斯储备数量
     */
    private Integer maxReserveCount;

    /**
     * 默认储备数量
     */
    private Integer defaultReserveCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
