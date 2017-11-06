package com.jens.springbootmodel.service.impl;

import com.jens.springbootmodel.entity.Demo;
import com.jens.springbootmodel.entity.convert.DemoConverter;
import com.jens.springbootmodel.entity.dto.DemoForAdd;
import com.jens.springbootmodel.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * =========================
 * FileName➤
 * Des☛
 * Date☀ 2017/10/16 || 17:26
 * @author Jens
 * =========================
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    DemoConverter demoConverter;
    @Autowired
    DemoService demoService;

    @Override
    public Boolean saveInfo(Demo demo) {
        return demoService.saveInfo(demo);
    }

    public Boolean saveInfoEx(DemoForAdd demoForAdd) throws Exception {
        Demo demo = demoConverter.addToDo(demoForAdd);
        return saveInfo(demo);
    }

}
