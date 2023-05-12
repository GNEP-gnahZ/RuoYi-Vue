package com.ruoyi.service.service.impl;

import java.util.List;

import com.ruoyi.service.dto.SaleinfoDto;
import com.ruoyi.service.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.service.mapper.SaleinfoMapper;
import com.ruoyi.service.domain.Saleinfo;
import com.ruoyi.service.service.ISaleinfoService;

/**
 * 订单业务Service业务层处理
 *
 * @author GNEPgnahZ
 * @date 2023-05-03
 */
@Service
public class SaleinfoServiceImpl implements ISaleinfoService
{
    @Autowired
    private SaleinfoMapper saleinfoMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 查询订单业务
     *
     * @param saleinfoId 订单业务主键
     * @return 订单业务
     */
    @Override
    public Saleinfo selectSaleinfoBySaleinfoId(Long saleinfoId)
    {
        return saleinfoMapper.selectSaleinfoBySaleinfoId(saleinfoId);
    }

    /**
     * 查询订单业务列表
     *
     * @param saleinfoDto 订单业务
     * @return 订单业务
     */
    @Override
    public List<SaleinfoDto> selectSaleinfoList(SaleinfoDto saleinfoDto)
    {
        return saleinfoMapper.selectSaleinfoList(saleinfoDto);
    }

    /**
     * 新增订单业务
     *
     * @param saleinfo 订单业务
     * @return 结果
     */
    @Override
    public int insertSaleinfo(Saleinfo saleinfo)
    {
        return saleinfoMapper.insertSaleinfo(saleinfo);
    }

    /**
     * 修改订单业务
     *
     * @param saleinfo 订单业务
     * @return 结果
     */
    @Override
    public int updateSaleinfo(Saleinfo saleinfo)
    {


        return saleinfoMapper.updateSaleinfo(saleinfo);
    }

    /**
     * 批量删除订单业务
     *
     * @param saleinfoIds 需要删除的订单业务主键
     * @return 结果
     */
    @Override
    public int deleteSaleinfoBySaleinfoIds(Long[] saleinfoIds)
    {
        return saleinfoMapper.deleteSaleinfoBySaleinfoIds(saleinfoIds);
    }

    /**
     * 删除订单业务信息
     *
     * @param saleinfoId 订单业务主键
     * @return 结果
     */
    @Override
    public int deleteSaleinfoBySaleinfoId(Long saleinfoId)
    {
        return saleinfoMapper.deleteSaleinfoBySaleinfoId(saleinfoId);
    }
}
