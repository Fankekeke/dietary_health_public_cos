package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.AttendanceInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
public interface AttendanceInfoMapper extends BaseMapper<AttendanceInfo> {

    /**
     * 分页查询打卡记录
     *
     * @param page           分页对象
     * @param attendanceInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryAttendancePage(Page<AttendanceInfo> page, @Param("attendanceInfo") AttendanceInfo attendanceInfo);

    /**
     * 根据用户获取打卡记录
     *
     * @param userId 用户id
     * @return 结果
     */
    List<LinkedHashMap<String, Object>> queryAttendanceRecordByUserId(@Param("userId") Integer userId);

    /**
     * 校验今日是否已经打卡
     * @param userId 用户ID
     * @return 结果
     */
    Integer queryTodayCheck(@Param("userId") Integer userId, @Param("createDate") String createDate);
}
