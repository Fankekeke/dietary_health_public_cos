package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.DishesInfo;
import cc.mrbird.febs.cos.dao.DishesInfoMapper;
import cc.mrbird.febs.cos.service.IDishesInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
@Service
public class DishesInfoServiceImpl extends ServiceImpl<DishesInfoMapper, DishesInfo> implements IDishesInfoService {

    /**
     * 分页查询菜品信息
     *
     * @param page       分页对象
     * @param dishesInfo 参数
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> queryDishesPage(Page<DishesInfo> page, DishesInfo dishesInfo) {
        return baseMapper.queryDishesPage(page, dishesInfo);
    }

    /**
     * 分页查询菜品信息
     *
     * @param page       分页对象
     * @param dishesInfo 参数
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> queryDishesByUserPage(Page<DishesInfo> page, DishesInfo dishesInfo) {
        return baseMapper.queryDishesByUserPage(page, dishesInfo);
    }

    /**
     * 根据用户查询菜品信息
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public List<DishesInfo> queryDishesByUserId(Integer userId) {
        return baseMapper.queryDishesByUserId(userId);
    }
}
