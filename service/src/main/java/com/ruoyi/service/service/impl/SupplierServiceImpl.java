package com.ruoyi.service.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.SupplierMapper;
import com.ruoyi.service.domain.Supplier;
import com.ruoyi.service.service.ISupplierService;

/**
 * 供应商信息表Service业务层处理
 * 
 * @author GNEPgnahZ
 * @date 2023-04-25
 */
@Service
public class SupplierServiceImpl implements ISupplierService 
{
    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 查询供应商信息表
     * 
     * @param supplierId 供应商信息表主键
     * @return 供应商信息表
     */
    @Override
    public Supplier selectSupplierBySupplierId(Long supplierId)
    {
        return supplierMapper.selectSupplierBySupplierId(supplierId);
    }

    /**
     * 查询供应商信息表列表
     * 
     * @param supplier 供应商信息表
     * @return 供应商信息表
     */
    @Override
    public List<Supplier> selectSupplierList(Supplier supplier)
    {
        return supplierMapper.selectSupplierList(supplier);
    }

    /**
     * 新增供应商信息表
     * 
     * @param supplier 供应商信息表
     * @return 结果
     */
    @Override
    public int insertSupplier(Supplier supplier)
    {
        return supplierMapper.insertSupplier(supplier);
    }

    /**
     * 修改供应商信息表
     * 
     * @param supplier 供应商信息表
     * @return 结果
     */
    @Override
    public int updateSupplier(Supplier supplier)
    {
        return supplierMapper.updateSupplier(supplier);
    }

    /**
     * 批量删除供应商信息表
     * 
     * @param supplierIds 需要删除的供应商信息表主键
     * @return 结果
     */
    @Override
    public int deleteSupplierBySupplierIds(Long[] supplierIds)
    {
        return supplierMapper.deleteSupplierBySupplierIds(supplierIds);
    }

    /**
     * 删除供应商信息表信息
     * 
     * @param supplierId 供应商信息表主键
     * @return 结果
     */
    @Override
    public int deleteSupplierBySupplierId(Long supplierId)
    {
        return supplierMapper.deleteSupplierBySupplierId(supplierId);
    }
}
