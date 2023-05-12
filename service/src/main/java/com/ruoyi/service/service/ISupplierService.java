package com.ruoyi.service.service;

import java.util.List;
import com.ruoyi.service.domain.Supplier;

/**
 * 供应商信息表Service接口
 * 
 * @author GNEPgnahZ
 * @date 2023-04-25
 */
public interface ISupplierService 
{
    /**
     * 查询供应商信息表
     * 
     * @param supplierId 供应商信息表主键
     * @return 供应商信息表
     */
    public Supplier selectSupplierBySupplierId(Long supplierId);

    /**
     * 查询供应商信息表列表
     * 
     * @param supplier 供应商信息表
     * @return 供应商信息表集合
     */
    public List<Supplier> selectSupplierList(Supplier supplier);

    /**
     * 新增供应商信息表
     * 
     * @param supplier 供应商信息表
     * @return 结果
     */
    public int insertSupplier(Supplier supplier);

    /**
     * 修改供应商信息表
     * 
     * @param supplier 供应商信息表
     * @return 结果
     */
    public int updateSupplier(Supplier supplier);

    /**
     * 批量删除供应商信息表
     * 
     * @param supplierIds 需要删除的供应商信息表主键集合
     * @return 结果
     */
    public int deleteSupplierBySupplierIds(Long[] supplierIds);

    /**
     * 删除供应商信息表信息
     * 
     * @param supplierId 供应商信息表主键
     * @return 结果
     */
    public int deleteSupplierBySupplierId(Long supplierId);
}
