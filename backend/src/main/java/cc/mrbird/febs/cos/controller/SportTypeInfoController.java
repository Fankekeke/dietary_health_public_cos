package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.SportTypeInfo;
import cc.mrbird.febs.cos.service.ISportTypeInfoService;
import cn.hutool.core.date.DateUtil;
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
@RequestMapping("/cos/sport-type-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SportTypeInfoController {

    private final ISportTypeInfoService sportTypeInfoService;
    
    /**
     * 分页查询运动种类
     *
     * @param page           分页对象
     * @param sportTypeInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<SportTypeInfo> page, SportTypeInfo sportTypeInfo) {
        return R.ok(sportTypeInfoService.querySportTypePage(page, sportTypeInfo));
    }

    /**
     * 查询所有运动种类
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(sportTypeInfoService.list());
    }

    /**
     * 获取运动种类详情
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/detail")
    public R detail(@RequestParam(value = "id", required = true) Integer id) {
        return R.ok(sportTypeInfoService.getById(id));
    }

    /**
     * 新增运动种类
     *
     * @param sportTypeInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(SportTypeInfo sportTypeInfo) {
        sportTypeInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(sportTypeInfoService.save(sportTypeInfo));
    }

    /**
     * 修改运动种类
     *
     * @param sportTypeInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(SportTypeInfo sportTypeInfo) {
        return R.ok(sportTypeInfoService.updateById(sportTypeInfo));
    }

    /**
     * 删除运动种类
     *
     * @param ids 参数
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(sportTypeInfoService.removeByIds(ids));
    }
}
