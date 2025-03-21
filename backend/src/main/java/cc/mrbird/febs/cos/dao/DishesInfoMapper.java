package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.DishesInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
public interface DishesInfoMapper extends BaseMapper<DishesInfo> {

    /**
     * 分页查询菜品信息
     *
     * @param page       分页对象
     * @param dishesInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryDishesPage(Page<DishesInfo> page, @Param("dishesInfo") DishesInfo dishesInfo);

    /**
     * 分页查询菜品信息
     *
     * @param page       分页对象
     * @param dishesInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryDishesByUserPage(Page<DishesInfo> page, @Param("dishesInfo") DishesInfo dishesInfo);

    /**
     * 根据用户查询菜品信息
     *
     * @param userId 用户ID
     * @return 结果
     */
    List<DishesInfo> queryDishesByUserId(@Param("userId") Integer userId);
}
