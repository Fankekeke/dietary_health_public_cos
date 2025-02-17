package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.AttendanceInfo;
import cc.mrbird.febs.cos.service.IAttendanceInfoService;
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
@RequestMapping("/cos/attendance-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AttendanceInfoController {

    private final IAttendanceInfoService attendanceInfoService;

    /**
     * 分页查询打卡记录
     *
     * @param page           分页对象
     * @param attendanceInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<AttendanceInfo> page, AttendanceInfo attendanceInfo) {
        return R.ok(attendanceInfoService.queryAttendancePage(page, attendanceInfo));
    }

    /**
     * 根据用户获取打卡记录
     *
     * @param userId 用户id
     * @return 结果
     */
    @GetMapping("/queryAttendanceRecordByUserId")
    public R queryAttendanceRecordByUserId(Integer userId) {
        return R.ok(attendanceInfoService.queryAttendanceRecordByUserId(userId));
    }

    /**
     * 查询所有打卡记录
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(attendanceInfoService.list());
    }

    /**
     * 获取打卡记录详情
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/detail")
    public R detail(@RequestParam(value = "id", required = true) Integer id) {
        return R.ok(attendanceInfoService.getById(id));
    }

    /**
     * 新增打卡记录
     *
     * @param attendanceInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(AttendanceInfo attendanceInfo) {
        attendanceInfo.setPutTakeDate(DateUtil.formatDateTime(new Date()));
        return R.ok(attendanceInfoService.save(attendanceInfo));
    }

    /**
     * 修改打卡记录
     *
     * @param attendanceInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(AttendanceInfo attendanceInfo) {
        return R.ok(attendanceInfoService.updateById(attendanceInfo));
    }

    /**
     * 删除打卡记录
     *
     * @param ids 参数
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(attendanceInfoService.removeByIds(ids));
    }
}
