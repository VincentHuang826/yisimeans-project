package com.yisimeans.controller;

import com.yisimeans.annotation.OperateLogAnno;
import com.yisimeans.pojo.PageResult;
import com.yisimeans.pojo.Result;
import com.yisimeans.pojo.Student;
import com.yisimeans.pojo.StudentQueryParam;
import com.yisimeans.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 學生控制類
 */

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 查詢學生列表
    @GetMapping
    public Result queryAll(StudentQueryParam studentQueryParam) {
        log.info("查詢學生列表: {}", studentQueryParam);
        PageResult<Student> pageResult = studentService.queryAll(studentQueryParam);
        return Result.success(pageResult);
    }

    // 新增學生
    @OperateLogAnno
    @PostMapping
    public Result addStudent(@RequestBody Student student) {
        log.info("新增學生: {}", student);
        studentService.addStudent(student);
        return Result.success();
    }

    // 根據ID查詢學生
    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id) {
        log.info("查詢學生ID: {}", id);
        Student student = studentService.queryById(id);
        return Result.success(student);
    }

    // 更新學生
    @OperateLogAnno
    @PutMapping
    public Result updateStudent(@RequestBody Student student) {
        log.info("更新學生: {}", student);
        studentService.updateStudent(student);
        return Result.success();
    }

    // 批量刪除學生
    @OperateLogAnno
    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids) {
        log.info("刪除學生ID: {}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }
}
