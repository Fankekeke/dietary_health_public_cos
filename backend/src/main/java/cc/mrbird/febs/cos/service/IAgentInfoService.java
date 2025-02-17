package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.AgentInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IAgentInfoService extends IService<AgentInfo> {

    /**
     * 分页查询代办任务
     *
     * @param page      分页对象
     * @param agentInfo 参数
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryAgentPage(Page<AgentInfo> page, AgentInfo agentInfo);
}
