package com.yisimeans.service.impl;

import com.yisimeans.mapper.ClazzManagementMapper;
import com.yisimeans.mapper.EmployeeMapper;
import com.yisimeans.mapper.StudentMapper;
import com.yisimeans.pojo.ClazzList;
import com.yisimeans.pojo.Position;
import com.yisimeans.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 數據統計service實現類
 */

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ClazzManagementMapper clazzManagementMapper;

    // 查詢員工職位統計人數
    @Override
    public Position getEmployeePosition() {
        List<Map<String, Object>> resultList = employeeMapper.getEmployeePosition();
        List<Object> positionList = resultList.stream().map(res -> res.get("position")).toList();
        List<Object> dataList = resultList.stream().map(res -> res.get("total")).toList();
        return new Position(positionList, dataList);
    }

    // 查詢員工性別統計人數
    @Override
    public List<Map<String, Object>> getEmployeeGender() {
        return employeeMapper.getEmployeeGender();
    }

    // 查詢班級學生統計人數
    @Override
    public ClazzList getClazzCount() {
        List<Map<String, Object>> resultList = clazzManagementMapper.getClazzCount();
        List<Object> clazzList = resultList.stream().map(res -> res.get("clazz")).toList();
        List<Object> dataList = resultList.stream().map(res -> res.get("total")).toList();
        return new ClazzList(clazzList, dataList);
    }

    // 查詢學生性別統計人數
    @Override
    public List<Map<String, Object>> getStudentGender() {
        return studentMapper.getStudentGender();
    }
}
