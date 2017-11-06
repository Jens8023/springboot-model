package com.jens.springbootmodel.service.impl;

import com.jens.springbootmodel.service.DistinctService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * =========================
 * FileName➤
 * Des☛
 * Date☀ 2017/10/24 || 11:03
 * @author Jens
 * =========================
 */
@Slf4j
@Service
public class DistinctServiceImpl implements DistinctService {

    @Autowired
    DistinctService distinctService;

    /**
     * 获取当前时间
     * @return
     */
    public static String dateToday() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(date);
        return time;
    }

    /**
     * 心跳
     * @param
     * @return
     */
    @Scheduled(initialDelay=1000, fixedDelay=30000)
    public String  heartbeat() {
        log.info("心跳测试: "+ dateToday());
        return dateToday();
    }

    @Override
    public Long distinctUserName(String userName) {
        return distinctService.distinctUserName(userName);
    }

}
