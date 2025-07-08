package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 員工證照類
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certificates {
    private Integer id; // 主鍵ID
    private String name; // 證照名稱
    private LocalDate issueDate; // 發證日期
    private LocalDate expirationDate; // 有效日期
    private Integer employeeId; // 關聯的員工ID
}
