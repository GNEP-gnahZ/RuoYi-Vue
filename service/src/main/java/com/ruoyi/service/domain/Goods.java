package com.ruoyi.service.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存信息对象 goods
 * 
 * @author GNEPgnahZ
 * @date 2023-05-03
 */
public class Goods extends BaseEntity{


    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long goodsId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String goodsType;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String goodsImg;

    /** 供应商 */
    @Excel(name = "供应商")
    private String goodsContact;

    /** 单位 */
    @Excel(name = "单位")
    private String goodsUnits;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long goodsNum;

    /** 进价 */
    @Excel(name = "进价")
    private BigDecimal goodsPrice;

    /** 总计 */
    @Excel(name = "总计")
    private BigDecimal goodsTotalPrice;

    /** 用法用量 */
    @Excel(name = "用法用量")
    private String dosage;

    /** 适用农作物 */
    @Excel(name = "适用农作物")
    private String crops;

    /** 针对疾病种类 */
    @Excel(name = "针对疾病种类")
    private String ills;

    /** 进货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "进货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date goodsCreatetime;

    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setGoodsName(String goodsName) 
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName() 
    {
        return goodsName;
    }
    public void setGoodsType(String goodsType) 
    {
        this.goodsType = goodsType;
    }

    public String getGoodsType() 
    {
        return goodsType;
    }
    public void setGoodsImg(String goodsImg) 
    {
        this.goodsImg = goodsImg;
    }

    public String getGoodsImg() 
    {
        return goodsImg;
    }
    public void setGoodsContact(String goodsContact) 
    {
        this.goodsContact = goodsContact;
    }

    public String getGoodsContact() 
    {
        return goodsContact;
    }
    public void setGoodsUnits(String goodsUnits) 
    {
        this.goodsUnits = goodsUnits;
    }

    public String getGoodsUnits() 
    {
        return goodsUnits;
    }
    public void setGoodsNum(Long goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public Long getGoodsNum()
    {
        return goodsNum;
    }
    public void setGoodsPrice(BigDecimal goodsPrice) 
    {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGoodsPrice() 
    {
        return goodsPrice;
    }
    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) 
    {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public BigDecimal getGoodsTotalPrice() 
    {
        return goodsTotalPrice;
    }
    public void setDosage(String dosage) 
    {
        this.dosage = dosage;
    }

    public String getDosage() 
    {
        return dosage;
    }
    public void setCrops(String crops) 
    {
        this.crops = crops;
    }

    public String getCrops() 
    {
        return crops;
    }
    public void setIlls(String ills) 
    {
        this.ills = ills;
    }

    public String getIlls() 
    {
        return ills;
    }
    public void setGoodsCreatetime(Date goodsCreatetime) 
    {
        this.goodsCreatetime = goodsCreatetime;
    }

    public Date getGoodsCreatetime() 
    {
        return goodsCreatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsId", getGoodsId())
            .append("goodsName", getGoodsName())
            .append("goodsType", getGoodsType())
            .append("goodsImg", getGoodsImg())
            .append("goodsContact", getGoodsContact())
            .append("goodsUnits", getGoodsUnits())
            .append("goodsNum", getGoodsNum())
            .append("goodsPrice", getGoodsPrice())
            .append("goodsTotalPrice", getGoodsTotalPrice())
            .append("dosage", getDosage())
            .append("crops", getCrops())
            .append("ills", getIlls())
            .append("goodsCreatetime", getGoodsCreatetime())
            .toString();
    }
}
