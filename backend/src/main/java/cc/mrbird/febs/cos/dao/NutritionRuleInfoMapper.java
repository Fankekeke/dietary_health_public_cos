package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.NutritionRuleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface NutritionRuleInfoMapper extends BaseMapper<NutritionRuleInfo> {

    /**
     * 分页查询营养规则信息
     *
     * @param page       分页对象
     * @param nutritionRuleInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryNutritionRulePage(Page<NutritionRuleInfo> page, @Param("nutritionRuleInfo") NutritionRuleInfo nutritionRuleInfo);
}
