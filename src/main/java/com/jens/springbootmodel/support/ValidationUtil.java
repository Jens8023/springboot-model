package com.jens.springbootmodel.support;


import com.jens.springbootmodel.common.ValidationConstant;
import com.jens.springbootmodel.entity.vo.RespResultVO;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

/**
 * =========================
 * FileName➤
 * Des☛
 * Date☀ 2017/10/16 || 17:22
 * @author Jens
 * =========================
 */
public class ValidationUtil {

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = factory.getValidator();

    /**
     * @apiNote 针对批量导入验证
     * @param obj
     * @param lineNum
     * @return
     */
    public static RespResultVO validateObject(Object obj, int lineNum) {
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);
        if (CollectionUtils.isEmpty(violations)) {
            return RespResultVO.builder().message(ValidationConstant.VALIDATION_SUCCESS).build();
        }

        StringBuilder builder = new StringBuilder();
        builder.append("第"+lineNum+"条数据格式错误：");
        for (ConstraintViolation<Object> violation : violations) {
            //builder.append(violation.getPropertyPath()).append(":");
            builder.append(violation.getMessage()).append("; ");
        }
        return RespResultVO.builder().message(builder.toString()).build();
    }

    /**
     * @apiNote 针对单条导入验证 -- 暂被BindingResult取代
     * @param obj
     * @return
     */
    public static RespResultVO validateObject(Object obj) {
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);
        if (CollectionUtils.isEmpty(violations)) {
            return RespResultVO.builder().message(ValidationConstant.VALIDATION_SUCCESS).build();
        }

        StringBuilder builder = new StringBuilder();
        for (ConstraintViolation<Object> violation : violations) {
            //builder.append(violation.getPropertyPath()).append(":");
            builder.append(violation.getMessage()).append(";");
        }
        return RespResultVO.builder().message(builder.toString()).build();
    }

    /**
     * @apiNote 自定义
     *
     */
    public static RespResultVO validateObject(BindingResult bindingResult) {
        StringBuilder msg = new StringBuilder();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String errorMessage = fieldError.getDefaultMessage();
            msg.append(errorMessage + "; ");
        }
        return RespResultVO.builder().message(msg.toString()).code(-1).build();
    }
}

