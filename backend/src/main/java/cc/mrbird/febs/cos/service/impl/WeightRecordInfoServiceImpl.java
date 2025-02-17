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
}
