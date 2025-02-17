package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.DietRecordInfo;
import cc.mrbird.febs.cos.dao.DietRecordInfoMapper;
import cc.mrbird.febs.cos.service.IDietRecordInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class DietRecordInfoServiceImpl extends ServiceImpl<DietRecordInfoMapper, DietRecordInfo> implements IDietRecordInfoService {

    /**
     * 分页查询饮食记录
     *
     * @param page           分页对象
     * @param dietRecordInfo 参数
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> queryDietRecordPage(Page<DietRecordInfo> page, DietRecordInfo dietRecordInfo) {
        return baseMapper.queryDietRecordPage(page, dietRecordInfo);
    }
}
