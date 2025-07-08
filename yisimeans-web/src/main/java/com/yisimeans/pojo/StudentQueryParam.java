package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 條件查詢學生類
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
    private String name; // 姓名
    private String number; // 學號
    private Integer clazzId; // 班級ID
    private Integer page = 1; // 頁數
    private Integer pageSize = 10; // 每頁展示紀錄數
}
