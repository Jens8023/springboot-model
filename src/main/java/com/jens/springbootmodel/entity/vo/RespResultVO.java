package com.jens.springbootmodel.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * =========================
 * FileName➤
 * Des☛
 * Date☀ 2017/10/16 || 17:22
 * @author Jens
 * =========================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "返回对象")
public class RespResultVO<T> implements Serializable {


    @ApiModelProperty(value = "正常code=0;异常code=-1")
    private Integer code;

    @ApiModelProperty(value = "异常信息")
    private String message;

    @ApiModelProperty(value = "单条数据")
    private T model;

    @ApiModelProperty(value = "多条数据")
    private List<T> dataList;

    @ApiModelProperty(value = "当前页")
    private Integer pageIndex;

    @ApiModelProperty(value = "总条数")
    private Long totalCount;

    @ApiModelProperty(value = "总页面数")
    private Integer totalPages;

}

