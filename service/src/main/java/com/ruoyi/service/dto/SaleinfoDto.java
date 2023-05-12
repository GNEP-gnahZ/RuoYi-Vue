package com.ruoyi.service.dto;

import com.ruoyi.service.domain.Saleinfo;


/**
 * @Description:
 * @Author: GNEPgnahZ
 */
public class SaleinfoDto extends Saleinfo {


    private Long goodsId;

    private String goodsName;

    private String goodsNum;
    @Override
    public String toString() {
        return "SaleinfoDto{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                '}';
    }
    public Long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public String getGoodsNum() {
        return goodsNum;
    }
    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }
}
