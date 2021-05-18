package com.xxxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author junw
 * @since 2021-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_salary")
@ApiModel(value="Salary对象", description="")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "基本工资")
    private BigDecimal basicSalary;

    @ApiModelProperty(value = "奖金")
    private BigDecimal bonus;

    @ApiModelProperty(value = "午餐补助")
    private BigDecimal lunchSalary;

    @ApiModelProperty(value = "交通补助")
    private BigDecimal trafficSalary;

    @ApiModelProperty(value = "应发工资")
    private BigDecimal allSalary;

    @ApiModelProperty(value = "养老金基数")
    private BigDecimal pensionBase;

    @ApiModelProperty(value = "养老金比率")
    private BigDecimal pensionPer;

    @ApiModelProperty(value = "启用时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "医疗基数")
    private BigDecimal medicalBase;

    @ApiModelProperty(value = "医疗保险比率")
    private BigDecimal medicalPer;

    @ApiModelProperty(value = "公积金基数")
    private BigDecimal accumulationFundBase;

    @ApiModelProperty(value = "公积金比率")
    private BigDecimal accumulationFundPer;

    @ApiModelProperty(value = "名称")
    private String name;


}
