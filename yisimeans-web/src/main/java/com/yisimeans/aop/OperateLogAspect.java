package com.yisimeans.aop;

import com.yisimeans.mapper.OperateLogMapper;
import com.yisimeans.pojo.OperateLog;
import com.yisimeans.util.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;


/**
 * 日誌aop類
 */

@Slf4j
@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.yisimeans.annotation.OperateLogAnno)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 執行方法開始時間
        long startTime = System.currentTimeMillis();
        // 調用方法
        Object result = pjp.proceed();
        // 執行方法結束時間
        long endTime = System.currentTimeMillis();
        // 計算執行耗時
        long costTime = endTime - startTime;

        // 封装日誌
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(CurrentHolder.getCurrentId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setCostTime(costTime);
        operateLog.setClassName(pjp.getTarget().getClass().getName());
        operateLog.setMethodName(pjp.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(pjp.getArgs()));
        operateLog.setReturnValue(result.toString());

        log.info("插入操作日誌: {}", operateLog);

        // 插入日誌
        operateLogMapper.insert(operateLog);
        return result;
    }
}
