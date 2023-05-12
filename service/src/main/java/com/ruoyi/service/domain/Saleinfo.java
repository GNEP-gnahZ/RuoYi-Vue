package com.ruoyi.service.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单业务对象 saleinfo
 * 
 * @author GNEPgnahZ
 * @date 2023-05-03
 */
public class Saleinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long saleinfoId;

    private Long parentId;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String saleinfoCustomerName;

    /** 销售数量 */
    @Excel(name = "销售数量")
    private Long saleinfoQuantiy;

    /** 状态 */
    @Excel(name = "状态")
    private String saleinfoStatus;

    /** 售价 */
    @Excel(name = "售价")
    private BigDecimal saleinfoPrice;

    /** 总计 */
    @Excel(name = "总计")
    private BigDecimal saleinfoTotalPrice;

    /** 销售时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "销售时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date saleinfoCreatetime;

    public void setSaleinfoId(Long saleinfoId) 
    {
        this.saleinfoId = saleinfoId;
    }
    public Long getSaleinfoId()
    {
        return saleinfoId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public Long getParentId() {
        return parentId;
    }

    public void setSaleinfoCustomerName(String saleinfoCustomerName) 
    {
        this.saleinfoCustomerName = saleinfoCustomerName;
    }

    public String getSaleinfoCustomerName() 
    {
        return saleinfoCustomerName;
    }
    public void setSaleinfoQuantiy(Long saleinfoQuantiy) 
    {
        this.saleinfoQuantiy = saleinfoQuantiy;
    }

    public Long getSaleinfoQuantiy() 
    {
        return saleinfoQuantiy;
    }
    public void setSaleinfoStatus(String saleinfoStatus) 
    {
        this.saleinfoStatus = saleinfoStatus;
    }

    public String getSaleinfoStatus() 
    {
        return saleinfoStatus;
    }
    public void setSaleinfoPrice(BigDecimal saleinfoPrice) 
    {
        this.saleinfoPrice = saleinfoPrice;
    }

    public BigDecimal getSaleinfoPrice() 
    {
        return saleinfoPrice;
    }
    public void setSaleinfoTotalPrice(BigDecimal saleinfoTotalPrice) 
    {
        this.saleinfoTotalPrice = saleinfoTotalPrice;
    }

    public BigDecimal getSaleinfoTotalPrice() 
    {
        return saleinfoTotalPrice;
    }
    public void setSaleinfoCreatetime(Date saleinfoCreatetime) 
    {
        this.saleinfoCreatetime = saleinfoCreatetime;
    }

    public Date getSaleinfoCreatetime() 
    {
        return saleinfoCreatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("saleinfoId", getSaleinfoId())
            .append("parentId",getParentId())
            .append("saleinfoCustomerName", getSaleinfoCustomerName())
            .append("saleinfoQuantiy", getSaleinfoQuantiy())
            .append("saleinfoStatus", getSaleinfoStatus())
            .append("saleinfoPrice", getSaleinfoPrice())
            .append("saleinfoTotalPrice", getSaleinfoTotalPrice())
            .append("saleinfoCreatetime", getSaleinfoCreatetime())
            .toString();
    }
}
