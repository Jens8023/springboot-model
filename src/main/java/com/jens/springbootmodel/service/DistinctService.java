package com.jens.springbootmodel.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * =========================
 * FileName➤
 * Des☛
 * Date☀ 2017/10/24 || 10:46
 * @author Jens
 * =========================
 */
@Repository
public interface DistinctService {

    //**存在感
    Long distinctUserName(@Param("username") String username);
}
