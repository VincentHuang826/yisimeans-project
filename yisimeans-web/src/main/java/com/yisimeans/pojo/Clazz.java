package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 班級類
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
    private Integer id; // 主鍵ID
    private String name; // 班級名稱
    private String room; // 教室
    private LocalDate beginDate; // 開課時間
    private LocalDate endDate; // 結課時間
    private Integer teacherId; // 導師ID
    private LocalDateTime createTime; // 創建時間
    private LocalDateTime updateTime; // 更新時間
    private String teacherName; // 導師姓名
    private String clazzStatus; // 課程狀態
}
