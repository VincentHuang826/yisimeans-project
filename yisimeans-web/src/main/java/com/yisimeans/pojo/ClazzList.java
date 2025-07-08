package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 班級人數統計類
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzList {
    private List clazzList; // 班級列表
    private List dataList; // 人數列表
}
