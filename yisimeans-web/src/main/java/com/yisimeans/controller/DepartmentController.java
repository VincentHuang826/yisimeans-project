package com.yisimeans.controller;

import com.yisimeans.annotation.OperateLogAnno;
import com.yisimeans.exception.CustomExceptions;
import com.yisimeans.pojo.Department;
import com.yisimeans.pojo.Result;
import com.yisimeans.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部門控制類
 */

@Slf4j
@RestController
@RequestMapping("/depts")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // 查詢所有部門
    @GetMapping
    public Result queryAll() {
        log.info("查詢所有部門");
        List<Department> departmentList = departmentService.queryAll();
        return Result.success(departmentList);
    }

    // 刪除部門
    @OperateLogAnno
    @DeleteMapping
    public Result deleteById(Integer id) throws CustomExceptions {
        log.info("根據ID刪除部門: {}" ,id);
        departmentService.deleteById(id);
        return Result.success();
    }

    // 新增部門
    @OperateLogAnno
    @PostMapping
    public Result addDepartment(@RequestBody Department department) {
        log.info("新增部門: {}" ,department);
        departmentService.addDepartment(department);
        return Result.success();
    }

    // 根據ID查詢部門
    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id) {
        log.info("根據ID查詢部門: {}" ,id);
        Department department = departmentService.queryById(id);
        return Result.success(department);
    }

    // 根據ID修改部門
    @OperateLogAnno
    @PutMapping
    public Result updateDepartment(@RequestBody Department department) {
        log.info("根據ID修改部門: {}" ,department);
        departmentService.updateDepartment(department);
        return Result.success();
    }
}
