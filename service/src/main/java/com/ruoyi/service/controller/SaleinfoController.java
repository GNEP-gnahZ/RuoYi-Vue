package com.ruoyi.service.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.service.dto.SaleinfoDto;
import com.ruoyi.service.service.IGoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.service.domain.Saleinfo;
import com.ruoyi.service.service.ISaleinfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单业务Controller
 * 
 * @author GNEPgnahZ
 * @date 2023-05-03
 */
@RestController
@RequestMapping("/service/saleinfo")
public class SaleinfoController extends BaseController
{
    @Autowired
    private ISaleinfoService saleinfoService;

    @Autowired
    private IGoodsService goodsService;
    /**
     * 查询订单业务列表
     */
    @PreAuthorize("@ss.hasPermi('service:saleinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleinfoDto saleinfoDto)
    {
        startPage();
        List<SaleinfoDto> saleinfoDtos = saleinfoService.selectSaleinfoList(saleinfoDto);
        return getDataTable(saleinfoDtos);
    }


    /**
     * 导出订单业务列表
     */
    @PreAuthorize("@ss.hasPermi('service:saleinfo:export')")
    @Log(title = "订单业务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SaleinfoDto saleinfoDto)
    {
        List<SaleinfoDto> list = saleinfoService.selectSaleinfoList(saleinfoDto);
        ExcelUtil<SaleinfoDto> util = new ExcelUtil<SaleinfoDto>(SaleinfoDto.class);
        util.exportExcel(response, list, "订单业务数据");
    }

    /**
     * 获取订单业务详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:saleinfo:query')")
    @GetMapping(value = "/{saleinfoId}")
    public AjaxResult getInfo(@PathVariable("saleinfoId") Long saleinfoId)
    {
        return success(saleinfoService.selectSaleinfoBySaleinfoId(saleinfoId));
    }

    /**
     * 新增订单业务
     */
    @PreAuthorize("@ss.hasPermi('service:saleinfo:add')")
    @Log(title = "订单业务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SaleinfoDto saleinfoDto)
    {
        Long goodsId = saleinfoDto.getGoodsId();
        Saleinfo saleinfo = new Saleinfo();
        saleinfo.setParentId(goodsId);
        Long saleinfoQuantiy = saleinfoDto.getSaleinfoQuantiy();
        BigDecimal saleinfoPrice = saleinfoDto.getSaleinfoPrice();
        BigDecimal num = new BigDecimal(saleinfoQuantiy);
        BigDecimal totalPrice = num.multiply(saleinfoPrice);
        saleinfoDto.setSaleinfoTotalPrice(totalPrice);
        BeanUtils.copyProperties(saleinfoDto,saleinfo,"parentId");
        return toAjax(saleinfoService.insertSaleinfo(saleinfo));
    }

    /**
     * 修改订单业务
     */
    @PreAuthorize("@ss.hasPermi('service:saleinfo:edit')")
    @Log(title = "订单业务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SaleinfoDto saleinfoDto)
    {
        Long goodsId = saleinfoDto.getGoodsId();
        Saleinfo saleinfo = new Saleinfo();
        saleinfo.setParentId(goodsId);
        Long saleinfoQuantiy = saleinfoDto.getSaleinfoQuantiy();
        BigDecimal saleinfoPrice = saleinfoDto.getSaleinfoPrice();
        BigDecimal num = new BigDecimal(saleinfoQuantiy);
        BigDecimal totalPrice = num.multiply(saleinfoPrice);
        saleinfoDto.setSaleinfoTotalPrice(totalPrice);
        BeanUtils.copyProperties(saleinfoDto,saleinfo,"parentId");
        return toAjax(saleinfoService.updateSaleinfo(saleinfo));
    }

    /**
     * 删除订单业务
     */
    @PreAuthorize("@ss.hasPermi('service:saleinfo:remove')")
    @Log(title = "订单业务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{saleinfoIds}")
    public AjaxResult remove(@PathVariable Long[] saleinfoIds)
    {
        return toAjax(saleinfoService.deleteSaleinfoBySaleinfoIds(saleinfoIds));
    }
}
