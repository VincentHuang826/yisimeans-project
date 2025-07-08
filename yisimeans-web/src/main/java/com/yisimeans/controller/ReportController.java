package com.yisimeans.controller;

import com.yisimeans.pojo.ClazzList;
import com.yisimeans.pojo.Position;
import com.yisimeans.pojo.Result;
import com.yisimeans.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 數據統計控制類
 */

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // 查詢員工職位統計人數
    @GetMapping("/empJobData")
    public Result getEmployeePosition() {
        log.info("查詢員工職位統計人數");
        Position resultList = reportService.getEmployeePosition();
        return Result.success(resultList);
    }

    // 查詢員工性別統計人數
    @GetMapping("/empGenderData")
    public Result getEmployeeGender() {
        log.info("查詢員工性別統計人數");
        List<Map<String, Object>> genderList = reportService.getEmployeeGender();
        return Result.success(genderList);
    }

    // 查詢班級學生統計人數
    @GetMapping("/studentCountData")
    public Result getClazzCount() {
        log.info("查詢班級學生統計人數");
        ClazzList clazzList = reportService.getClazzCount();
        return Result.success(clazzList);
    }

    // 查詢學生性別統計人數
    @GetMapping("/studentGenderData")
    public Result getStudentGender() {
        log.info("查詢學生性別統計人數");
        List<Map<String, Object>> genderList = reportService.getStudentGender();
        return Result.success(genderList);
    }
}
