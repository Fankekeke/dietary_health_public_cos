package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.DietRecordInfo;
import cc.mrbird.febs.cos.entity.DishesInfo;
import cc.mrbird.febs.cos.entity.UserInfo;
import cc.mrbird.febs.cos.service.IDietRecordInfoService;
import cc.mrbird.febs.cos.service.IDishesInfoService;
import cc.mrbird.febs.cos.service.IUserInfoService;
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
@RequestMapping("/cos/diet-record-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DietRecordInfoController {

    private final IDietRecordInfoService dietRecordInfoService;

    private final IDishesInfoService dishesInfoService;

    private final IUserInfoService userInfoService;

    /**
     * 分页查询饮食记录
     *
     * @param page           分页对象
     * @param dietRecordInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<DietRecordInfo> page, DietRecordInfo dietRecordInfo) {
        return R.ok(dietRecordInfoService.queryDietRecordPage(page, dietRecordInfo));
    }

    /**
     * 查询所有饮食记录
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(dietRecordInfoService.list());
    }

    /**
     * 获取饮食记录详情
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/detail")
    public R detail(@RequestParam(value = "id", required = true) Integer id) {
        return R.ok(dietRecordInfoService.getById(id));
    }

    /**
     * 新增饮食记录
     *
     * @param dietRecordInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(DietRecordInfo dietRecordInfo) {
        dietRecordInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        // 获取菜品信息
        DishesInfo dishesInfo = dishesInfoService.getById(dietRecordInfo.getDishesId());
        if (dishesInfo != null) {
            dietRecordInfo.setHeat(dishesInfo.getHeat());
            dietRecordInfo.setProtein(dishesInfo.getProtein());
            dietRecordInfo.setFat(dishesInfo.getFat());
        }

        if (dietRecordInfo.getUserId() != null) {
            UserInfo userInfo = userInfoService.getOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUserId, dietRecordInfo.getUserId()));
            if (userInfo != null) {
                dietRecordInfo.setUserId(userInfo.getId());
            }
        }
        return R.ok(dietRecordInfoService.save(dietRecordInfo));
    }

    /**
     * 修改饮食记录
     *
     * @param dietRecordInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(DietRecordInfo dietRecordInfo) {
        return R.ok(dietRecordInfoService.updateById(dietRecordInfo));
    }

    /**
     * 删除饮食记录
     *
     * @param ids 参数
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(dietRecordInfoService.removeByIds(ids));
    }
}
