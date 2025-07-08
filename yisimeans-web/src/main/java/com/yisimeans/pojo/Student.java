package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 學生類
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id; // 主鍵ID
    private String name; // 姓名
    private String number; // 學號
    private Integer gender; // 性別
    private String phone; // 電話
    private LocalDate birthday; // 生日
    private String address; // 地址
    private Integer clazzId; // 班級ID
    private LocalDateTime createTime; // 創建時間
    private LocalDateTime updateTime; // 更新時間
    private String clazzName; // 班級名稱
    private List<EmergencyContact> emergencyContactList; // 緊急聯絡人
}
