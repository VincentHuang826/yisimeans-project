package com.yisimeans.service;

import com.yisimeans.pojo.OperateLog;
import com.yisimeans.pojo.PageResult;

/**
 * 日誌service
 */


public interface OperateLogService {
    // 查詢日誌列表
    PageResult<OperateLog> queryLog(Integer page, Integer pageSize);
}
