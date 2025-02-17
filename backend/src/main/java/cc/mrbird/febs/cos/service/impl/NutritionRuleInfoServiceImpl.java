package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.NutritionRuleInfo;
import cc.mrbird.febs.cos.dao.NutritionRuleInfoMapper;
import cc.mrbird.febs.cos.service.INutritionRuleInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class NutritionRuleInfoServiceImpl extends ServiceImpl<NutritionRuleInfoMapper, NutritionRuleInfo> implements INutritionRuleInfoService {

    /**
     * 分页查询营养规则信息
     *
     * @param page       分页对象
     * @param nutritionRuleInfo 参数
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> queryNutritionRulePage(Page<NutritionRuleInfo> page, NutritionRuleInfo nutritionRuleInfo) {
        return baseMapper.queryNutritionRulePage(page, nutritionRuleInfo);
    }
}
