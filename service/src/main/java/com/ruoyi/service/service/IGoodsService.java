package com.ruoyi.service.service;

import java.util.List;
import com.ruoyi.service.domain.Goods;

/**
 * 库存信息Service接口
 * 
 * @author GNEPgnahZ
 * @date 2023-05-03
 */
public interface IGoodsService 
{
    /**
     * 查询库存信息
     * 
     * @param goodsId 库存信息主键
     * @return 库存信息
     */
    public Goods selectGoodsByGoodsId(Long goodsId);

    public List<Goods> selectGoodsNameList();
    /**
     * 查询库存信息列表
     * 
     * @param goods 库存信息
     * @return 库存信息集合
     */
    public List<Goods> selectGoodsList(Goods goods);

    /**
     * 新增库存信息
     * 
     * @param goods 库存信息
     * @return 结果
     */
    public int insertGoods(Goods goods);

    /**
     * 修改库存信息
     * 
     * @param goods 库存信息
     * @return 结果
     */
    public int updateGoods(Goods goods);

    /**
     * 批量删除库存信息
     * 
     * @param goodsIds 需要删除的库存信息主键集合
     * @return 结果
     */
    public int deleteGoodsByGoodsIds(String[] goodsIds);

    /**
     * 删除库存信息信息
     * 
     * @param goodsId 库存信息主键
     * @return 结果
     */
    public int deleteGoodsByGoodsId(String goodsId);
}
