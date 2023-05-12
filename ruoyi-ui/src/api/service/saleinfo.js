import request from '@/utils/request'

// 查询订单业务列表
export function listSaleinfo(query) {
  return request({
    url: '/service/saleinfo/list',
    method: 'get',
    params: query
  })
}

// 查询订单业务详细
export function getSaleinfo(saleinfoId) {
  return request({
    url: '/service/saleinfo/' + saleinfoId,
    method: 'get'
  })
}
// 查询商品名称
export function getGoodsName() {
  return request({
    url: '/service/goods/goodsname',
    method: 'get'
  })
}
// 新增订单业务
export function addSaleinfo(data) {
  return request({
    url: '/service/saleinfo',
    method: 'post',
    data: data
  })
}

// 修改订单业务
export function updateSaleinfo(data) {
  return request({
    url: '/service/saleinfo',
    method: 'put',
    data: data
  })
}

// 删除订单业务
export function delSaleinfo(saleinfoId) {
  return request({
    url: '/service/saleinfo/' + saleinfoId,
    method: 'delete'
  })
}
