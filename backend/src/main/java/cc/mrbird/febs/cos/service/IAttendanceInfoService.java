package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.AttendanceInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
public interface IAttendanceInfoService extends IService<AttendanceInfo> {

    /**
     * 分页查询打卡记录
     *
     * @param page           分页对象
     * @param attendanceInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryAttendancePage(Page<AttendanceInfo> page, AttendanceInfo attendanceInfo);

    /**
     * 根据用户获取打卡记录
     *
     * @param userId 用户id
     * @return 结果
     */
    List<LinkedHashMap<String, Object>> queryAttendanceRecordByUserId(Integer userId);
}
