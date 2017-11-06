package com.jens.springbootmodel.entity.bo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * =========================
 * FileName➤
 * Des☛
 * Date☀ 2017/10/23 || 16:55
 * @author Jens
 * =========================
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "其他对象")
public class ElseData {

    private String els;
}
