package com.lhj.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface LogDao {
    int insertLog(@Param("message") String message,@Param("time") LocalDateTime time);
}
