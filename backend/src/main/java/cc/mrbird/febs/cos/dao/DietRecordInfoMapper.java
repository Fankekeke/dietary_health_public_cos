package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.DietRecordInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface DietRecordInfoMapper extends BaseMapper<DietRecordInfo> {

    /**
     * 分页查询饮食记录
     *
     * @param page           分页对象
     * @param dietRecordInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryDietRecordPage(Page<DietRecordInfo> page, @Param("dietRecordInfo") DietRecordInfo dietRecordInfo);
}
