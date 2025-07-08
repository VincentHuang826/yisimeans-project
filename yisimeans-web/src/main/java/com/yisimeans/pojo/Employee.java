package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 員工類
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id; // 主鍵ID
    private String name; // 員工姓名
    private String username; // 使用者名稱
    private String password; // 密碼
    private Integer gender; // 性別
    private String phone; // 手機
    private String email; // 信箱
    private LocalDate birthday; // 生日
    private String address; // 地址
    private Integer salary; // 薪資
    private Integer departmentId; // 所屬部門
    private Integer position; // 職位 1:經理 2:主管 3:專員 4:助理 5:實習生
    private LocalDate startDate; // 入職日期
    private LocalDateTime createTime; // 創建時間
    private LocalDateTime updateTime; // 更新時間
    private String departmentName; // 部門名稱
    private List<Certificates> certificatesList; // 證照列表
}
