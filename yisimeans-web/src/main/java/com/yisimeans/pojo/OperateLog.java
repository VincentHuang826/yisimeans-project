package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 日誌類
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperateLog {
    private Integer id; // 主鍵ID
    private Integer operateEmpId; // 操作人ID
    private LocalDateTime operateTime; // 操作時間
    private String className; // 調用類名
    private String methodName; // 調用方法名
    private String methodParams; // 方法參數
    private String returnValue; // 方法返回值
    private Long costTime; // 執行耗時
}
