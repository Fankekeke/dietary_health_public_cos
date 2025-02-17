package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.AttendanceInfo;
import cc.mrbird.febs.cos.dao.AttendanceInfoMapper;
import cc.mrbird.febs.cos.service.IAttendanceInfoService;
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
public class AttendanceInfoServiceImpl extends ServiceImpl<AttendanceInfoMapper, AttendanceInfo> implements IAttendanceInfoService {

    /**
     * 分页查询打卡记录
     *
     * @param page           分页对象
     * @param attendanceInfo 参数
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> queryAttendancePage(Page<AttendanceInfo> page, AttendanceInfo attendanceInfo) {
        return baseMapper.queryAttendancePage(page, attendanceInfo);
    }

    /**
     * 根据用户获取打卡记录
     *
     * @param userId 用户id
     * @return 结果
     */
    @Override
    public List<LinkedHashMap<String, Object>> queryAttendanceRecordByUserId(Integer userId) {
        return baseMapper.queryAttendanceRecordByUserId(userId);
    }
}
