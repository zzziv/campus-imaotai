package com.oddfar.campus.business.service.impl;

import com.oddfar.campus.business.service.IMTService;
import com.oddfar.campus.business.service.IShopService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Elsen 2023/8/25
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IMTServiceImplTest {

    @Resource
    private IShopService shopService;

    @Test
    public void refreshAllAreaInventory() {
        shopService.refreshAllAreaInventory();
    }
}