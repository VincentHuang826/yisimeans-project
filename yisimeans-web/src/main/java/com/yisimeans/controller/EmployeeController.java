package com.yisimeans.controller;

import com.yisimeans.annotation.OperateLogAnno;
import com.yisimeans.pojo.Employee;
import com.yisimeans.pojo.EmployeeQueryParam;
import com.yisimeans.pojo.PageResult;
import com.yisimeans.pojo.Result;
import com.yisimeans.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 員工控制類
 */

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // 分頁查詢員工
    @GetMapping
    public Result queryAll(EmployeeQueryParam employeeQueryParam) {
        log.info("分頁查詢員工: {}", employeeQueryParam);
        PageResult<Employee> resultList = employeeService.queryAll(employeeQueryParam);
        return Result.success(resultList);
    }

    // 新增員工
    @OperateLogAnno
    @PostMapping
    public Result addEmployee(@RequestBody Employee employee) {
        log.info("新增員工: {}", employee);
        employeeService.addEmployee(employee);
        return Result.success();
    }

    // 批量刪除員工
    @OperateLogAnno
    @DeleteMapping
    public Result deleteByIds(@RequestParam List<Integer> ids) {
        log.info("刪除員工: {}", ids);
        employeeService.deleteByIds(ids);
        return Result.success();
    }

    // 根據ID查詢員工
    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id) {
        log.info("根據ID查詢員工: {}", id);
        Employee employee = employeeService.queryById(id);
        return Result.success(employee);
    }

    // 更新員工
    @OperateLogAnno
    @PutMapping
    public Result updateEmployee(@RequestBody Employee employee) {
        log.info("更新員工: {}", employee);
        employeeService.updateEmployee(employee);
        return Result.success();
    }

    // 查詢全部員工
    @GetMapping("/list")
    public Result getEmployeeList() {
        log.info("查詢全部員工");
        List<Employee> employeeList = employeeService.getEmployeeList();
        return Result.success(employeeList);
    }
}
