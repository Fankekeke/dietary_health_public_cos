package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.WeightRecordInfo;
import cc.mrbird.febs.cos.service.IWeightRecordInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/weight-record-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WeightRecordInfoController {

    private final IWeightRecordInfoService weightRecordInfoService;

    /**
     * 分页查询体重记录信息
     *
     * @param page             分页对象
     * @param weightRecordInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<WeightRecordInfo> page, WeightRecordInfo weightRecordInfo) {
        return R.ok(weightRecordInfoService.queryWeightPage(page, weightRecordInfo));
    }

    /**
     * 查询所有体重记录信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(weightRecordInfoService.list());
    }

    /**
     * 获取体重记录信息详情
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/detail")
    public R detail(@RequestParam(value = "id", required = true) Integer id) {
        return R.ok(weightRecordInfoService.getById(id));
    }

    /**
     * 新增体重记录信息
     *
     * @param weightRecordInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(WeightRecordInfo weightRecordInfo) {
        return R.ok(weightRecordInfoService.save(weightRecordInfo));
    }

    /**
     * 修改体重记录信息
     *
     * @param weightRecordInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(WeightRecordInfo weightRecordInfo) {
        return R.ok(weightRecordInfoService.updateById(weightRecordInfo));
    }

    /**
     * 删除体重记录信息
     *
     * @param ids 参数
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(weightRecordInfoService.removeByIds(ids));
    }
}
