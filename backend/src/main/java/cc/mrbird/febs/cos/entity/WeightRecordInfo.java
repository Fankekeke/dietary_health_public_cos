package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 体重记录
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WeightRecordInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 饮水量
     */
    private BigDecimal waterAmount;

    /**
     * 运动量
     */
    private BigDecimal sportAmount;

    /**
     * 体重
     */
    private BigDecimal weight;

    /**
     * 备注
     */
    private String content;

    /**
     * 创建时间
     */
    private String createDate;


}
