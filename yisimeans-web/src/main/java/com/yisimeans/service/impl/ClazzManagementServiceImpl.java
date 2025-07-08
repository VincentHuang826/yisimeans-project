package com.yisimeans.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yisimeans.exception.CustomExceptions;
import com.yisimeans.mapper.ClazzManagementMapper;
import com.yisimeans.pojo.Clazz;
import com.yisimeans.pojo.ClazzQueryParam;
import com.yisimeans.pojo.PageResult;
import com.yisimeans.service.ClazzManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 班級管理service實現類
 */

@Service
public class ClazzManagementServiceImpl implements ClazzManagementService {

    @Autowired
    private ClazzManagementMapper clazzManagementMapper;

    // 分頁查詢班級列表
    @Override
    public PageResult<Clazz> queryAll(ClazzQueryParam clazzQueryParam) {
        // 調用pageHelper並設置分頁參數
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        // 調用mapper分頁查詢方法
        List<Clazz> pageList = clazzManagementMapper.queryAll(clazzQueryParam);

        // 判斷課程狀態
        for (Clazz clazz : pageList) {
            if (clazz.getBeginDate().isAfter(LocalDate.now())) {
                clazz.setClazzStatus("未開課");
            } else if (clazz.getEndDate().isBefore(LocalDate.now())) {
                clazz.setClazzStatus("已結課");
            } else clazz.setClazzStatus("開課中");
        }

        // 將返回的pageList轉型為Page對象
        Page<Clazz> p = (Page<Clazz>) pageList;
        // 調用Page方法封装查詢結果
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    // 新增班級
    @Override
    public void addClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzManagementMapper.addClazz(clazz);
    }

    // 根據ID查詢班級
    @Override
    public Clazz queryById(Integer id) {
        return clazzManagementMapper.queryById(id);
    }

    // 更新班級
    @Override
    public void updateClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzManagementMapper.updateClazz(clazz);
    }

    // 刪除班級
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteClazz(Integer id) throws CustomExceptions {
        // 檢查班級是否還有學生
        Integer person = clazzManagementMapper.checkPerson(id);

        if (person == 0) {
            // 調用刪除方法
            clazzManagementMapper.deleteClazz(id);
        } else {
            throw new CustomExceptions("無法刪除班級，該班級尚有" + person + "位學生");
        }
    }

    // 查詢所有班級
    @Override
    public List<Clazz> getClazzList() {
        return clazzManagementMapper.getClazzList();
    }
}
