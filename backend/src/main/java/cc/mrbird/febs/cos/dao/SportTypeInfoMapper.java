package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.SportTypeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface SportTypeInfoMapper extends BaseMapper<SportTypeInfo> {

    /**
     * 分页查询运动种类
     *
     * @param page           分页对象
     * @param sportTypeInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> querySportTypePage(Page<SportTypeInfo> page, @Param("sportTypeInfo") SportTypeInfo sportTypeInfo);

    /**
     * 分页查询运动种类
     *
     * @param page           分页对象
     * @param sportTypeInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> querySportTypeByUserPage(Page<SportTypeInfo> page, @Param("sportTypeInfo") SportTypeInfo sportTypeInfo);
}
