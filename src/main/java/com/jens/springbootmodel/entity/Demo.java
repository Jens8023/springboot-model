package com.jens.springbootmodel.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * =========================
 * FileName➤
 * Des☛
 * Date☀ 2017/11/3 || 13:30
 * @author Jens
 * =========================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "demo对象")
public class Demo {

    @ApiModelProperty(value = "用户ID", hidden = true)
    private String userId;

    @ApiModelProperty(value = "用户名称", required = true)
    private String userName;

    @ApiModelProperty(value = "密码", required = true)
    private String passWord;
}
