package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.WeightRecordInfo;
import cc.mrbird.febs.cos.dao.WeightRecordInfoMapper;
import cc.mrbird.febs.cos.service.IWeightRecordInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class WeightRecordInfoServiceImpl extends ServiceImpl<WeightRecordInfoMapper, WeightRecordInfo> implements IWeightRecordInfoService {

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
}
