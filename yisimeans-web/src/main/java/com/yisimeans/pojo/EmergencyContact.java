package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 學生緊急聯絡人類
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmergencyContact {
    private Integer id; // 主鍵ID
    private String name; // 姓名
    private String phone; // 電話
    private String relation; // 關係
    private Integer studentId; // 關聯學生ID
}
