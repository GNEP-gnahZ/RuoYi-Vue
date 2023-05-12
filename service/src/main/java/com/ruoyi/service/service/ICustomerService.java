package com.ruoyi.service.service;

import java.util.List;
import com.ruoyi.service.domain.Customer;

/**
 * 客户信息Service接口
 * 
 * @author GNEPgnahZ
 * @date 2023-04-25
 */
public interface ICustomerService 
{
    /**
     * 查询客户信息
     * 
     * @param customerId 客户信息主键
     * @return 客户信息
     */
    public Customer selectCustomerByCustomerId(Long customerId);

    /**
     * 查询客户信息列表
     * 
     * @param customer 客户信息
     * @return 客户信息集合
     */
    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 新增客户信息
     * 
     * @param customer 客户信息
     * @return 结果
     */
    public int insertCustomer(Customer customer);

    /**
     * 修改客户信息
     * 
     * @param customer 客户信息
     * @return 结果
     */
    public int updateCustomer(Customer customer);

    /**
     * 批量删除客户信息
     * 
     * @param customerIds 需要删除的客户信息主键集合
     * @return 结果
     */
    public int deleteCustomerByCustomerIds(Long[] customerIds);

    /**
     * 删除客户信息信息
     * 
     * @param customerId 客户信息主键
     * @return 结果
     */
    public int deleteCustomerByCustomerId(Long customerId);
}
