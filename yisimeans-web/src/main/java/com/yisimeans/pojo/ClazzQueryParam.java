package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 條件查詢班級類
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzQueryParam {
    private String name; // 班級名稱
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; // 開課日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; // 結課日期
    private Integer page = 1; // 頁數
    private Integer pageSize = 5; // 每頁展示紀錄數
}
