package com.ruoyi.service.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商信息表对象 supplier
 * 
 * @author GNEPgnahZ
 * @date 2023-04-25
 */
public class Supplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    @TableId(type = IdType.AUTO)
    private Long supplierId;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String supplierAddress;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplierContact;

    /** 联系人 */
    @Excel(name = "联系人")
    private String supplierName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String supplierNumber;

    /** 备注 */
    @Excel(name = "备注")
    private String supplierRemarks;

    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setSupplierAddress(String supplierAddress) 
    {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierAddress() 
    {
        return supplierAddress;
    }
    public void setSupplierContact(String supplierContact) 
    {
        this.supplierContact = supplierContact;
    }

    public String getSupplierContact() 
    {
        return supplierContact;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setSupplierNumber(String supplierNumber) 
    {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierNumber() 
    {
        return supplierNumber;
    }
    public void setSupplierRemarks(String supplierRemarks) 
    {
        this.supplierRemarks = supplierRemarks;
    }

    public String getSupplierRemarks() 
    {
        return supplierRemarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("supplierId", getSupplierId())
            .append("supplierAddress", getSupplierAddress())
            .append("supplierContact", getSupplierContact())
            .append("supplierName", getSupplierName())
            .append("supplierNumber", getSupplierNumber())
            .append("supplierRemarks", getSupplierRemarks())
            .toString();
    }
}
