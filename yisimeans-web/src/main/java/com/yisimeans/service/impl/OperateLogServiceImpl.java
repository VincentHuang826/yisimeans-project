package com.yisimeans.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yisimeans.mapper.OperateLogMapper;
import com.yisimeans.pojo.OperateLog;
import com.yisimeans.pojo.PageResult;
import com.yisimeans.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日誌service實現類
 */

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    // 查詢日誌列表
    @Override
    public PageResult<OperateLog> queryLog(Integer page, Integer pageSize) {
        // 調用pageHelper並設置分頁參數
        PageHelper.startPage(page, pageSize);
        // 調用mapper分頁查詢方法
        List<OperateLog> pageList = operateLogMapper.queryLog();
        // 將返回的pageList轉型為Page對象
        Page<OperateLog> p = (Page<OperateLog>) pageList;
        // 調用Page方法封装查詢結果
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
