package com.ruoyi.service.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.service.domain.Goods;
import com.ruoyi.service.service.IGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存信息Controller
 * 
 * @author GNEPgnahZ
 * @date 2023-05-03
 */
@RestController
@RequestMapping("/service/goods")
public class GoodsController extends BaseController
{
    @Autowired
    private IGoodsService goodsService;
    /**
     * 查询商品名称
     *
     * @return {@link List}<{@link Goods}>
     */
    @GetMapping("/goodsname")
    public AjaxResult goodsName(){
        List<Goods> goods = goodsService.selectGoodsNameList();
        return success(goods);
    }



    /**
     * 查询库存信息列表
     */
    @PreAuthorize("@ss.hasPermi('service:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(Goods goods)
    {
        startPage();
        List<Goods> list = goodsService.selectGoodsList(goods);
        return getDataTable(list);
    }


//    public Map<String,String> goodsName(){
//
//        String goodsvalue = "value";
//        List<String> values = goodsService.selectGoodsNameList();
//        Map<String,String> rep = new HashMap<>();
//        for (String value :values){
//            rep.put(goodsvalue,value);
//        }
//        return rep;
//    }
    /**
     * 导出库存信息列表
     */
    @PreAuthorize("@ss.hasPermi('service:goods:export')")
    @Log(title = "库存信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Goods goods)
    {
        List<Goods> list = goodsService.selectGoodsList(goods);
        ExcelUtil<Goods> util = new ExcelUtil<Goods>(Goods.class);
        util.exportExcel(response, list, "库存信息数据");
    }

    /**
     * 获取库存信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:goods:query')")
    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Long goodsId)
    {
        return success(goodsService.selectGoodsByGoodsId(goodsId));
    }

    /**
     * 新增库存信息
     */
    @PreAuthorize("@ss.hasPermi('service:goods:add')")
    @Log(title = "库存信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Goods goods)
    {
        return toAjax(goodsService.insertGoods(goods));
    }

    /**
     * 修改库存信息
     */
    @PreAuthorize("@ss.hasPermi('service:goods:edit')")
    @Log(title = "库存信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Goods goods)
    {
        Long goodsNum = goods.getGoodsNum();
        BigDecimal goodsPrice = goods.getGoodsPrice();
        BigDecimal num = new BigDecimal(goodsNum);
        BigDecimal totalPrice = num.multiply(goodsPrice);
        goods.setGoodsTotalPrice(totalPrice);
        return toAjax(goodsService.updateGoods(goods));
    }

    /**
     * 删除库存信息
     */
    @PreAuthorize("@ss.hasPermi('service:goods:remove')")
    @Log(title = "库存信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable String[] goodsIds)
    {
        return toAjax(goodsService.deleteGoodsByGoodsIds(goodsIds));
    }
}
