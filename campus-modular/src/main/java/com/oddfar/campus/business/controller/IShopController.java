package com.oddfar.campus.business.controller;

import com.oddfar.campus.business.domain.ShopInventoryReq;
import com.oddfar.campus.business.domain.ShopInventoryRes;
import com.oddfar.campus.business.entity.IShop;
import com.oddfar.campus.business.mapper.IShopItemInventoryMapper;
import com.oddfar.campus.business.mapper.IShopMapper;
import com.oddfar.campus.business.service.IShopService;
import com.oddfar.campus.common.annotation.ApiResource;
import com.oddfar.campus.common.domain.PageResult;
import com.oddfar.campus.common.domain.R;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * i茅台商品Controller
 *
 * @author oddfar
 * @date 2023-07-05
 */
@RestController
@RequestMapping("/imt/shop")
@ApiResource(name = "i茅台商品Controller")
public class IShopController {
    @Resource
    private IShopService iShopService;
    @Resource
    private IShopMapper iShopMapper;
    @Resource
    private IShopItemInventoryMapper inventoryMapper;

    /**
     * 查询i茅台商品列表
     */
    @GetMapping("/list")
    public R list(IShop iShop) {
        PageResult<IShop> page = iShopMapper.selectPage(iShop);

        return R.ok().put(page);
    }


    /**
     * 刷新i茅台商品列表
     */
    @GetMapping(value = "/refresh", name = "刷新i茅台商品列表")
    @PreAuthorize("@ss.resourceAuth()")
    public R refreshShop() {
        iShopService.refreshShop();
        return R.ok();
    }

    /**
     * 刷新i茅台预约商品列表
     */
    @GetMapping(value = "/inventory", name = "i茅台预约商品库存列表")
    @PreAuthorize("@ss.resourceAuth()")
    public R shopInventory(ShopInventoryReq req) {
        Integer total = inventoryMapper.shopInventoryCount(req);
        List<ShopInventoryRes> data = inventoryMapper.shopInventory(req);
        PageResult<ShopInventoryRes> page = new PageResult<>();
        page.setTotal(total);
        page.setRows(data);
        return R.ok().put(page);
    }
}
