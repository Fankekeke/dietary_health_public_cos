package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.SportTypeInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface ISportTypeInfoService extends IService<SportTypeInfo> {

    /**
     * 分页查询运动种类
     *
     * @param page           分页对象
     * @param sportTypeInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> querySportTypePage(Page<SportTypeInfo> page, SportTypeInfo sportTypeInfo);

    /**
     * 分页查询运动种类
     *
     * @param page           分页对象
     * @param sportTypeInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> querySportTypeByUserPage(Page<SportTypeInfo> page, SportTypeInfo sportTypeInfo);
}
