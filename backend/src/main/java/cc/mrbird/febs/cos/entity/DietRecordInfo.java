package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 饮食记录
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DietRecordInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 餐品ID
     */
    private Integer dishesId;

    /**
     * 热量
     */
    private BigDecimal heat;

    /**
     * 蛋白质
     */
    private BigDecimal protein;

    /**
     * 脂肪
     */
    private BigDecimal fat;

    /**
     * 创建时间
     */
    private String createDate;

    @TableField(exist = false)
    private String dishesName;

    @TableField(exist = false)
    private String userName;


}
