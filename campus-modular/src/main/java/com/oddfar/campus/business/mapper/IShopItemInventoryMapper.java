package com.oddfar.campus.business.mapper;

import com.oddfar.campus.business.domain.ShopInventoryReq;
import com.oddfar.campus.business.domain.ShopInventoryRes;
import com.oddfar.campus.business.entity.IIShopItemInventory;
import com.oddfar.campus.common.core.BaseMapperX;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * I茅台商品Mapper接口
 *
 * @author oddfar
 * @date 2023-07-02
 */

public interface IShopItemInventoryMapper extends BaseMapperX<IIShopItemInventory> {
    //清空指定表
    @Update("truncate table i_shop_item_inventory")
    void truncateShopItemInventory();


    /**
     * 批量插入
     *
     * @param shopList 购物清单
     */
    void inserts(@Param("list") List<IIShopItemInventory> shopList);

    /**
     * 商店库存
     *
     * @param req 要求事情
     * @return {@code List<ShopInventoryRes>}
     */
    List<ShopInventoryRes> shopInventory(@Param("req") ShopInventoryReq req);
}
