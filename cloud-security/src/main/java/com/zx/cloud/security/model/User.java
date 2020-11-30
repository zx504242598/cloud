package com.zx.cloud.security.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;


import java.io.Serializable;
import java.time.LocalDateTime;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author root
 * @since 2020-06-30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    private String role;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除(1.否 -1.是)")
    @TableLogic
    private String isDelete;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
