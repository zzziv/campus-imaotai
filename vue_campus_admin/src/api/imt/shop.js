import request from '@/utils/request'

// 查询i茅台商品列表
export function listShop(query) {
  return request({
    url: '/imt/shop/list',
    method: 'get',
    params: query
  })
}

// 查询i茅台商品库存列表
export function inventory(query) {
  return request({
    url: '/imt/shop/inventory',
    method: 'get',
    params: query
  })
}

// 删除i茅台商品
export function refreshShop() {
  return request({
    url: '/imt/shop/refresh' ,
    method: 'get'
  })
}
