package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.DietRecordInfo;
import cc.mrbird.febs.cos.entity.NutritionRuleInfo;
import cc.mrbird.febs.cos.entity.WeightRecordInfo;
import cc.mrbird.febs.cos.dao.WeightRecordInfoMapper;
import cc.mrbird.febs.cos.service.IDietRecordInfoService;
import cc.mrbird.febs.cos.service.INutritionRuleInfoService;
import cc.mrbird.febs.cos.service.IWeightRecordInfoService;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WeightRecordInfoServiceImpl extends ServiceImpl<WeightRecordInfoMapper, WeightRecordInfo> implements IWeightRecordInfoService {

    private final IDietRecordInfoService dietRecordInfoService;

    private final INutritionRuleInfoService nutritionRuleInfoService;

    /**
     * 分页查询体重记录信息
     *
     * @param page             分页对象
     * @param weightRecordInfo 参数
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> queryWeightPage(Page<WeightRecordInfo> page, WeightRecordInfo weightRecordInfo) {
        return baseMapper.queryWeightPage(page, weightRecordInfo);
    }

    /**
     * 获取数据统计
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public LinkedHashMap<String, Object> selectRateWithDays(Integer userId) {
        // 返回数据
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>() {
            {
                put("caloriesIn", baseMapper.selectCaloriesWithinDays(userId));
                put("caloriesOut", baseMapper.selectCaloriesWithoutDays(userId));
                put("weight", baseMapper.selectWeightWithinDays(userId));
            }
        };
        return result;
    }

    /**
     * 查询今日摄入量
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public LinkedHashMap<String, Object> queryHeatByUserToday(Integer userId) {
        // 获取用户今日饮食记录
        List<DietRecordInfo> dietRecordInfoList = dietRecordInfoService.list(Wrappers.<DietRecordInfo>lambdaQuery().eq(DietRecordInfo::getUserId, userId));

        // 查询营养规则
        NutritionRuleInfo rule = nutritionRuleInfoService.getById(1);

        // 返回数据
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>() {
            {
                put("heat", BigDecimal.ZERO);
                put("protein", BigDecimal.ZERO);
                put("fat", BigDecimal.ZERO);
                put("heatRule", rule.getHeat());
                put("proteinRule", rule.getProtein());
                put("fatRule", rule.getFat());
            }
        };

        if (CollectionUtil.isEmpty(dietRecordInfoList)) {
            return result;
        }

        BigDecimal heat = dietRecordInfoList.stream().map(DietRecordInfo::getHeat).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal protein = dietRecordInfoList.stream().map(DietRecordInfo::getProtein).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal fat = dietRecordInfoList.stream().map(DietRecordInfo::getFat).reduce(BigDecimal.ZERO, BigDecimal::add);

        result.put("heat", heat);
        result.put("protein", protein);
        result.put("fat", fat);
        return result;
    }
}
