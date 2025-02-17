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
 * 菜品管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DishesInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜品编号
     */
    private String code;

    /**
     * 菜品名称
     */
    private String name;

    /**
     * 菜品描述
     */
    private String content;

    /**
     * 原料
     */
    private String rawMaterial;

    /**
     * 份量
     */
    private Integer portion;

    /**
     * 口味
     */
    private String taste;

    /**
     * 状态（0.下架 1.上架）
     */
    private String status;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 图片
     */
    private String images;

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
     * 所属用户
     */
    private Integer userId;


}
