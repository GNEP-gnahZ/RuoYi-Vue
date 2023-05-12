package com.ruoyi.service.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.GoodsMapper;
import com.ruoyi.service.domain.Goods;
import com.ruoyi.service.service.IGoodsService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 库存信息Service业务层处理
 * 
 * @author GNEPgnahZ
 * @date 2023-05-03
 */
@Service
public class GoodsServiceImpl implements IGoodsService 
{
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 查询库存信息
     * 
     * @param goodsId 库存信息主键
     * @return 库存信息
     */
    @Override
    public Goods selectGoodsByGoodsId(Long goodsId)
    {
        return goodsMapper.selectGoodsByGoodsId(goodsId);
    }

    @Override
    public List<Goods> selectGoodsNameList() {
        return goodsMapper.selectGoodsNameList();
    }

    /**
     * 查询库存信息列表
     * 
     * @param goods 库存信息
     * @return 库存信息
     */
    @Override
    public List<Goods> selectGoodsList(Goods goods)
    {
        return goodsMapper.selectGoodsList(goods);
    }

    /**
     * 新增库存信息
     * 
     * @param goods 库存信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertGoods(Goods goods)
    {
        Long goodsNum = goods.getGoodsNum();
        BigDecimal goodsPrice = goods.getGoodsPrice();
        BigDecimal num = new BigDecimal(goodsNum);
        BigDecimal totalPrice = num.multiply(goodsPrice);
        goods.setGoodsTotalPrice(totalPrice);
        return goodsMapper.insertGoods(goods);
    }

    /**
     * 修改库存信息
     * 
     * @param goods 库存信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateGoods(Goods goods)
    {
        Long goodsNum = goods.getGoodsNum();
        BigDecimal goodsPrice = goods.getGoodsPrice();
        BigDecimal num = new BigDecimal(goodsNum);
        BigDecimal totalPrice = num.multiply(goodsPrice);
        goods.setGoodsTotalPrice(totalPrice);
        return goodsMapper.updateGoods(goods);
    }

    /**
     * 批量删除库存信息
     * 
     * @param goodsIds 需要删除的库存信息主键
     * @return 结果
     */
    @Override
    public int deleteGoodsByGoodsIds(String[] goodsIds)
    {
        return goodsMapper.deleteGoodsByGoodsIds(goodsIds);
    }

    /**
     * 删除库存信息信息
     * 
     * @param goodsId 库存信息主键
     * @return 结果
     */
    @Override
    public int deleteGoodsByGoodsId(String goodsId)
    {
        return goodsMapper.deleteGoodsByGoodsId(goodsId);
    }
}
