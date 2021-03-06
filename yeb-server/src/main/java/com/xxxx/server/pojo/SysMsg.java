package com.xxxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@TableName("t_sys_msg")
@ApiModel(value="SysMsg对象", description="")
public class SysMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "消息id")
    private Integer msgid;

    @ApiModelProperty(value = "0表示群发消息")
    private String type;

    @ApiModelProperty(value = "这条消息是给谁的")
    private String sendid;

    @ApiModelProperty(value = "0 未读 1 已读")
    private String state;


}
