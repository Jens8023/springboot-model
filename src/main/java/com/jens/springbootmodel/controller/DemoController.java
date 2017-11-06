package com.jens.springbootmodel.controller;

import com.jens.springbootmodel.common.TitleConstant;
import com.jens.springbootmodel.entity.dto.DemoForAdd;
import com.jens.springbootmodel.entity.vo.RespResultVO;
import com.jens.springbootmodel.service.impl.DemoServiceImpl;
import com.jens.springbootmodel.support.ValidationUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * =========================
 * FileName➤
 * Des☛
 * Date☀ 2017/10/16 || 17:21
 * @author Jens
 * =========================
 */
@Slf4j
@RestController
@RequestMapping(value = "demo")
public class DemoController {

    @Autowired
    DemoServiceImpl demoServiceImpl;

    @ApiOperation(value = TitleConstant.INFO_SAVE, notes = "")
    @PostMapping(value = "/info")
    public RespResultVO saveInfo(
            @RequestBody @ApiParam(name = "dto", value="DemoForAdd", required = true)
            @Valid DemoForAdd demoForAdd, BindingResult bindingResult) {
        log.info("controller--" + TitleConstant.INFO_SAVE);
        if (bindingResult.hasErrors()) {
            return ValidationUtil.validateObject(bindingResult);
        }
        try{
            demoServiceImpl.saveInfoEx(demoForAdd);
            return RespResultVO.builder().message("新增成功").code(0).build();
        }catch (Exception e){
            log.error(e.getMessage());
            return RespResultVO.builder().message(e.getMessage()).code(-1).build();
        }
    }
}
