package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.WeightRecordInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface WeightRecordInfoMapper extends BaseMapper<WeightRecordInfo> {

    /**
     * 分页查询体重记录信息
     *
     * @param page             分页对象
     * @param weightRecordInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryWeightPage(Page<WeightRecordInfo> page, @Param("weightRecordInfo") WeightRecordInfo weightRecordInfo);
}
