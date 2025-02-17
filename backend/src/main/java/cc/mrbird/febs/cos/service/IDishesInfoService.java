package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.DishesInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IDishesInfoService extends IService<DishesInfo> {

    /**
     * 分页查询菜品信息
     *
     * @param page       分页对象
     * @param dishesInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryDishesPage(Page<DishesInfo> page, DishesInfo dishesInfo);
}
