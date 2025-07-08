package com.yisimeans.controller;

import com.yisimeans.annotation.OperateLogAnno;
import com.yisimeans.exception.CustomExceptions;
import com.yisimeans.pojo.Clazz;
import com.yisimeans.pojo.ClazzQueryParam;
import com.yisimeans.pojo.PageResult;
import com.yisimeans.pojo.Result;
import com.yisimeans.service.ClazzManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班級管理控制類
 */

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzManagementController {

    @Autowired
    private ClazzManagementService clazzManagementService;

    // 分頁查詢班級列表
    @GetMapping
    public Result queryAll(ClazzQueryParam clazzQueryParam) {
        log.info("分頁查詢班級列表: {}", clazzQueryParam);
        PageResult<Clazz> clazzList = clazzManagementService.queryAll(clazzQueryParam);
        return Result.success(clazzList);
    }

    // 新增班級
    @OperateLogAnno
    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz) {
        log.info("新增班級: {}", clazz);
        clazzManagementService.addClazz(clazz);
        return Result.success();
    }

    // 根據ID查詢班級
    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id) {
        log.info("查詢班級ID: {}", id);
        Clazz clazz = clazzManagementService.queryById(id);
        return Result.success(clazz);
    }

    // 更新班級
    @OperateLogAnno
    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz) {
        log.info("更新班級: {}", clazz);
        clazzManagementService.updateClazz(clazz);
        return Result.success();
    }

    // 刪除班級
    @OperateLogAnno
    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable Integer id) throws CustomExceptions {
        log.info("刪除班級: {}", id);
        clazzManagementService.deleteClazz(id);
        return Result.success();
    }

    // 查詢所有班級
    @GetMapping("/list")
    public Result getClazzList() {
        log.info("查詢所有班級");
        List<Clazz> clazzList = clazzManagementService.getClazzList();
        return Result.success(clazzList);
    }
}
