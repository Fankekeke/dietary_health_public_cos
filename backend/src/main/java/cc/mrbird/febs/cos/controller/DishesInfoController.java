package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.DishesInfo;
import cc.mrbird.febs.cos.entity.UserInfo;
import cc.mrbird.febs.cos.service.IDishesInfoService;
import cc.mrbird.febs.cos.service.IUserInfoService;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/dishes-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DishesInfoController {

    private final IDishesInfoService dishesInfoService;

    private final IUserInfoService userInfoService;

    /**
     * 分页查询菜品信息
     *
     * @param page       分页对象
     * @param dishesInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<DishesInfo> page, DishesInfo dishesInfo) {
        return R.ok(dishesInfoService.queryDishesPage(page, dishesInfo));
    }

    /**
     * 根据用户查询菜品信息
     *
     * @param userId 用户id
     * @return 结果
     */
    @GetMapping("/list/all")
    public R queryDishesByUserId(Integer userId) {
        List<DishesInfo> dishesInfoList = dishesInfoService.list(Wrappers.<DishesInfo>lambdaQuery().isNull(DishesInfo::getUserId));
        for (DishesInfo dishesInfo1 : dishesInfoList) {
            dishesInfo1.setUserName("系统食谱");
        }
        List<DishesInfo> userDishesList = dishesInfoService.queryDishesByUserId(userId);

        // dishesInfoList和userDishesList合并
        dishesInfoList.addAll(userDishesList);
        return R.ok(dishesInfoList);
    }

    /**
     * 根据用户查询菜品信息
     *
     * @param page       分页对象
     * @param dishesInfo 参数
     * @return 结果
     */
    @GetMapping("/page/user")
    public R queryDishesByUserPage(Page<DishesInfo> page, DishesInfo dishesInfo) {
        return R.ok(dishesInfoService.queryDishesByUserPage(page, dishesInfo));
    }

    /**
     * 查询用户所选的菜品
     *
     * @param userId 用户ID
     * @return 结果
     */
    @GetMapping("/queryDishesByUserIdCheck")
    public R queryDishesByUserIdCheck(Integer userId) {
        List<DishesInfo> userDishesList = dishesInfoService.queryDishesByUserId(userId);
        return R.ok(userDishesList);
    }

    /**
     * 查询所有菜品信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(dishesInfoService.list());
    }

    /**
     * 获取菜品信息详情
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/detail")
    public R detail(@RequestParam(value = "id", required = true) Integer id) {
        return R.ok(dishesInfoService.getById(id));
    }

    /**
     * 新增菜品信息
     *
     * @param dishesInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(DishesInfo dishesInfo) {
        dishesInfo.setCode("DIS-" + System.currentTimeMillis());
        dishesInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        if (dishesInfo.getUserId() != null) {
            UserInfo userInfo = userInfoService.getOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUserId, dishesInfo.getUserId()));
            if (userInfo != null) {
                dishesInfo.setUserId(userInfo.getId());
            }
        }
        return R.ok(dishesInfoService.save(dishesInfo));
    }

    /**
     * 新增菜品信息
     *
     * @param dishesInfo 参数
     * @return 结果
     */
    @PostMapping("/saveByUser")
    public R saveByUser(DishesInfo dishesInfo) {
        dishesInfo.setCode("DIS-" + System.currentTimeMillis());
        dishesInfo.setId(null);
        dishesInfo.setContent("0");
        dishesInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        if (dishesInfo.getUserId() != null) {
            UserInfo userInfo = userInfoService.getOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUserId, dishesInfo.getUserId()));
            if (userInfo != null) {
                dishesInfo.setUserId(userInfo.getId());
            }
        }
        return R.ok(dishesInfoService.save(dishesInfo));
    }

    /**
     * 修改菜品信息
     *
     * @param dishesInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(DishesInfo dishesInfo) {
        return R.ok(dishesInfoService.updateById(dishesInfo));
    }

    /**
     * 删除菜品信息
     *
     * @param ids 参数
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(dishesInfoService.removeByIds(ids));
    }
}
