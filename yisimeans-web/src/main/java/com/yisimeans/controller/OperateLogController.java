package com.yisimeans.controller;

import com.yisimeans.pojo.OperateLog;
import com.yisimeans.pojo.PageResult;
import com.yisimeans.pojo.Result;
import com.yisimeans.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日誌控制類
 */

@Slf4j
@RequestMapping("/log")
@RestController
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

    // 查詢日誌列表
    @GetMapping("/page")
    public Result queryLog(@RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("查詢日誌列表");
        PageResult<OperateLog> logList = operateLogService.queryLog(page, pageSize);
        return Result.success(logList);
    }
}
