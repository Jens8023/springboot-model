package com.jens.springbootmodel.entity.convert;

import com.jens.springbootmodel.entity.Demo;
import com.jens.springbootmodel.entity.dto.DemoForAdd;
import org.springframework.stereotype.Component;

/**
 * =========================
 * FileName➤
 * Des☛
 * Date☀ 2017/11/3 || 14:03
 * @author Jens
 *  =========================
 */
@Component
public class DemoConverter {

    public Demo addToDo(DemoForAdd data) {
        return Demo.builder()
                .userName(data.getUserName())
                .passWord(data.getPassWord())
                .build();
    }
}
