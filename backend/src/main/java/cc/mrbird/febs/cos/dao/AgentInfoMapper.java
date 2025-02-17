package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.AgentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface AgentInfoMapper extends BaseMapper<AgentInfo> {

    /**
     * 分页查询代办任务
     *
     * @param page      分页对象
     * @param agentInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryAgentPage(Page<AgentInfo> page, @Param("agentInfo") AgentInfo agentInfo);
}
