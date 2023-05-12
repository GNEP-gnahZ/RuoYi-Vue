import request from '@/utils/request'

// 查询库存信息列表
export function listGoods(query) {
  return request({
    url: '/service/goods/list',
    method: 'get',
    params: query
  })
}

// 查询库存信息详细
export function getGoods(goodsId) {
  return request({
    url: '/service/goods/' + goodsId,
    method: 'get'
  })
}

// 新增库存信息
export function addGoods(data) {
  return request({
    url: '/service/goods',
    method: 'post',
    data: data
  })
}

// 修改库存信息
export function updateGoods(data) {
  return request({
    url: '/service/goods',
    method: 'put',
    data: data
  })
}

// 删除库存信息
export function delGoods(goodsId) {
  return request({
    url: '/service/goods/' + goodsId,
    method: 'delete'
  })
}
