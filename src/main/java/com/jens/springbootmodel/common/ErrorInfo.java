package com.jens.springbootmodel.common;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode
public class ErrorInfo {
    private int lineNum;
    private String message;
}
