package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 部門類
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id; // 主鍵ID
    private String name; // 部門名稱
    private LocalDateTime createTime; // 創建時間
    private LocalDateTime updateTime; // 更新時間
}
