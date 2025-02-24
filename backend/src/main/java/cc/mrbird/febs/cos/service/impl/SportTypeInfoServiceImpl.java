package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.SportTypeInfo;
import cc.mrbird.febs.cos.dao.SportTypeInfoMapper;
import cc.mrbird.febs.cos.service.ISportTypeInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class SportTypeInfoServiceImpl extends ServiceImpl<SportTypeInfoMapper, SportTypeInfo> implements ISportTypeInfoService {

    /**
     * 分页查询运动种类
     *
     * @param page           分页对象
     * @param sportTypeInfo 参数
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> querySportTypePage(Page<SportTypeInfo> page, SportTypeInfo sportTypeInfo) {
        return baseMapper.querySportTypePage(page, sportTypeInfo);
    }
}
