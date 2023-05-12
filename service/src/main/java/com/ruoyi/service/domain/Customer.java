package com.ruoyi.service.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户信息对象 customer
 * 
 * @author GNEPgnahZ
 * @date 2023-04-25
 */
public class Customer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    @TableId(type = IdType.AUTO)
    private Long customerId;

    /** 客户地址 */
    @Excel(name = "客户地址")
    private String customerAddress;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String customerName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String customerNumber;

    /** 备注 */
    @Excel(name = "备注")
    private String customerRemarks;

    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setCustomerAddress(String customerAddress) 
    {
        this.customerAddress = customerAddress;
    }

    public String getCustomerAddress() 
    {
        return customerAddress;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setCustomerNumber(String customerNumber) 
    {
        this.customerNumber = customerNumber;
    }

    public String getCustomerNumber() 
    {
        return customerNumber;
    }
    public void setCustomerRemarks(String customerRemarks) 
    {
        this.customerRemarks = customerRemarks;
    }

    public String getCustomerRemarks() 
    {
        return customerRemarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customerId", getCustomerId())
            .append("customerAddress", getCustomerAddress())
            .append("customerName", getCustomerName())
            .append("customerNumber", getCustomerNumber())
            .append("customerRemarks", getCustomerRemarks())
            .toString();
    }
}
