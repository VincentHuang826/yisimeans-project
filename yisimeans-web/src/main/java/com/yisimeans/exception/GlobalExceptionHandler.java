package com.yisimeans.exception;

import com.yisimeans.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局異常處理器類
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 攔截所有異常
    @ExceptionHandler
    public Result exceptionHandler(Exception e) {
        log.info("系統發生異常: {}",  e.getMessage());
        return Result.error("系統異常，請聯繫系統管理員。");
    }

    // 攔截資料重複異常
    @ExceptionHandler
    public Result duplicateKeyExceptionHandler(DuplicateKeyException d) {
        String errMsg = d.getMessage();
        log.error("系統發生異常: {}", errMsg);
        int index = errMsg.indexOf("Duplicate entry");
        String[] arr = errMsg.substring(index).split(" ");
        return Result.error(arr[2] + "已使用，請重新輸入。");
    }

    // 攔截班級或部門尚有人數異常
    @ExceptionHandler
    public Result customExceptionHandler(CustomExceptions c) {
        String errMsg = c.getMessage();
        log.info("系統發生異常: {}", errMsg);
        return Result.error(errMsg);
    }
}
