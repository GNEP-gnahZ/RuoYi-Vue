import request from '@/utils/request'

// 查询供应商信息表列表
export function listSupplier(query) {
  return request({
    url: '/service/supplier/list',
    method: 'get',
    params: query
  })
}

// 查询供应商信息表详细
export function getSupplier(supplierId) {
  return request({
    url: '/service/supplier/' + supplierId,
    method: 'get'
  })
}

// 新增供应商信息表
export function addSupplier(data) {
  return request({
    url: '/service/supplier',
    method: 'post',
    data: data
  })
}

// 修改供应商信息表
export function updateSupplier(data) {
  return request({
    url: '/service/supplier',
    method: 'put',
    data: data
  })
}

// 删除供应商信息表
export function delSupplier(supplierId) {
  return request({
    url: '/service/supplier/' + supplierId,
    method: 'delete'
  })
}
