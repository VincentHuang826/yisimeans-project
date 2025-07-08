package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 員工數據統計類
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private List positionList; // 職位列表
    private List dataList; // 人數列表
}
