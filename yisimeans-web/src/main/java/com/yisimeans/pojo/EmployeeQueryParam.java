package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 *  條件查詢員工類
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeQueryParam {
    private Integer page = 1; // 頁數
    private Integer pageSize = 10; // 每頁展示紀錄數
    private String name; // 員工姓名
    private Integer gender; // 員工性別
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; // 入職時間-開始
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; // 入職時間-結束
}
