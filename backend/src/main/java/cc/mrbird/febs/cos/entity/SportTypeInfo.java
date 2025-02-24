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
 * 运动种类
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SportTypeInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 运动编号
     */
    private String code;

    /**
     * 运动名称
     */
    private String name;

    /**
     * 运动描述
     */
    private String content;

    /**
     * 热量
     */
    private BigDecimal heat;

    /**
     * 运动时间（分钟）
     */
    private Integer sportTime;

    /**
     * 图片
     */
    private String images;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 所属用户
     */
    private Integer userId;


}
