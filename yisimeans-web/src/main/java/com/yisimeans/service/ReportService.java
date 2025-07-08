package com.yisimeans.service;

import com.yisimeans.pojo.ClazzList;
import com.yisimeans.pojo.Position;

import java.util.List;
import java.util.Map;

/**
 * 數據統計service
 */


public interface ReportService {
    // 查詢員工職位統計人數
    Position getEmployeePosition();

    // 查詢員工性別統計人數
    List<Map<String, Object>> getEmployeeGender();

    // 查詢班級學生統計人數
    ClazzList getClazzCount();

    // 查詢學生性別統計人數
    List<Map<String, Object>> getStudentGender();
}
