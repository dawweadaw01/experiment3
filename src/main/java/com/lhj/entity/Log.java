package com.lhj.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Log {
    private Integer id;
    private String message;
    private LocalDateTime time;
}
