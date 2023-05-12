package com.ruoyi.service.mapper;

import java.util.List;
import com.ruoyi.service.domain.Saleinfo;
import com.ruoyi.service.dto.SaleinfoDto;

/**
 * 订单业务Mapper接口
 *
 * @author GNEPgnahZ
 * @date 2023-05-03
 */
public interface SaleinfoMapper
{
    /**
     * 查询订单业务
     *
     * @param saleinfoId 订单业务主键
     * @return 订单业务
     */
    public Saleinfo selectSaleinfoBySaleinfoId(Long saleinfoId);

    /**
     * 查询订单业务列表
     *
     * @param saleinfoDto 订单业务
     * @return 订单业务集合
     */
    public List<SaleinfoDto> selectSaleinfoList(SaleinfoDto saleinfoDto);

    /**
     * 新增订单业务
     *
     * @param Saleinfo 订单业务
     * @return 结果
     */
    public int insertSaleinfo(Saleinfo Saleinfo);

    /**
     * 修改订单业务
     *
     * @param saleinfo 订单业务
     * @return 结果
     */
    public int updateSaleinfo(Saleinfo saleinfo);

    /**
     * 删除订单业务
     *
     * @param saleinfoId 订单业务主键
     * @return 结果
     */
    public int deleteSaleinfoBySaleinfoId(Long saleinfoId);

    /**
     * 批量删除订单业务
     *
     * @param saleinfoIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSaleinfoBySaleinfoIds(Long[] saleinfoIds);
}
