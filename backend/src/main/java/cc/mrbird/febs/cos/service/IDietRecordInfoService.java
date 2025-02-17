package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.DietRecordInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IDietRecordInfoService extends IService<DietRecordInfo> {

    /**
     * 分页查询饮食记录
     *
     * @param page           分页对象
     * @param dietRecordInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryDietRecordPage(Page<DietRecordInfo> page, DietRecordInfo dietRecordInfo);
}
