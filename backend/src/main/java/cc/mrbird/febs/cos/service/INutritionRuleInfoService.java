package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.NutritionRuleInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface INutritionRuleInfoService extends IService<NutritionRuleInfo> {

    /**
     * 分页查询营养规则信息
     *
     * @param page       分页对象
     * @param nutritionRuleInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryNutritionRulePage(Page<NutritionRuleInfo> page, NutritionRuleInfo nutritionRuleInfo);
}
