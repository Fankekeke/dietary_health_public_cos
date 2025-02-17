package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.NutritionRuleInfo;
import cc.mrbird.febs.cos.service.INutritionRuleInfoService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/nutrition-rule-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NutritionRuleInfoController {

    private final INutritionRuleInfoService nutritionRuleInfoService;

    /**
     * 分页查询营养规则信息
     *
     * @param page       分页对象
     * @param nutritionRuleInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<NutritionRuleInfo> page, NutritionRuleInfo nutritionRuleInfo) {
        return R.ok(nutritionRuleInfoService.queryNutritionRulePage(page, nutritionRuleInfo));
    }

    /**
     * 查询所有营养规则信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(nutritionRuleInfoService.list());
    }

    /**
     * 获取营养规则信息详情
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/detail")
    public R detail(@RequestParam(value = "id", required = true) Integer id) {
        return R.ok(nutritionRuleInfoService.getById(id));
    }

    /**
     * 新增营养规则信息
     *
     * @param nutritionRuleInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(NutritionRuleInfo nutritionRuleInfo) {
        return R.ok(nutritionRuleInfoService.save(nutritionRuleInfo));
    }

    /**
     * 修改营养规则信息
     *
     * @param nutritionRuleInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(NutritionRuleInfo nutritionRuleInfo) {
        return R.ok(nutritionRuleInfoService.updateById(nutritionRuleInfo));
    }

    /**
     * 删除营养规则信息
     *
     * @param ids 参数
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(nutritionRuleInfoService.removeByIds(ids));
    }
}
