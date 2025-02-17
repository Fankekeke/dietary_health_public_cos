package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.AgentInfo;
import cc.mrbird.febs.cos.service.IAgentInfoService;
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
@RequestMapping("/cos/agent-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AgentInfoController {

    private final IAgentInfoService agentInfoService;

    /**
     * 分页查询代办任务
     *
     * @param page      分页对象
     * @param agentInfo 参数
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<AgentInfo> page, AgentInfo agentInfo) {
        return R.ok(agentInfoService.queryAgentPage(page, agentInfo));
    }

    /**
     * 查询所有代办任务
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(agentInfoService.list());
    }

    /**
     * 获取代办任务详情
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/detail")
    public R detail(@RequestParam(value = "id", required = true) Integer id) {
        return R.ok(agentInfoService.getById(id));
    }

    /**
     * 新增代办任务
     *
     * @param agentInfo 参数
     * @return 结果
     */
    @PostMapping
    public R save(AgentInfo agentInfo) {
        agentInfo.setComplateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(agentInfoService.save(agentInfo));
    }

    /**
     * 修改代办任务
     *
     * @param agentInfo 参数
     * @return 结果
     */
    @PutMapping
    public R edit(AgentInfo agentInfo) {
        return R.ok(agentInfoService.updateById(agentInfo));
    }

    /**
     * 删除代办任务
     *
     * @param ids 参数
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(agentInfoService.removeByIds(ids));
    }
}
