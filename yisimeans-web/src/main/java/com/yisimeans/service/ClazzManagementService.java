package com.yisimeans.service;

import com.yisimeans.exception.CustomExceptions;
import com.yisimeans.pojo.Clazz;
import com.yisimeans.pojo.ClazzQueryParam;
import com.yisimeans.pojo.PageResult;

import java.util.List;

/**
 * 班級管理service
 */


public interface ClazzManagementService {
    // 分頁查詢班級列表
    PageResult<Clazz> queryAll(ClazzQueryParam clazzQueryParam);

    // 新增班級
    void addClazz(Clazz clazz);

    // 根據ID查詢班級
    Clazz queryById(Integer id);

    // 更新班級
    void updateClazz(Clazz clazz);

    // 刪除班級
    void deleteClazz(Integer id) throws CustomExceptions;

    // 查詢所有班級
    List<Clazz> getClazzList();
}
