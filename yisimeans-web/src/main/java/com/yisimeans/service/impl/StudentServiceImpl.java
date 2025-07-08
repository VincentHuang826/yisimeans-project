package com.yisimeans.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yisimeans.mapper.EmergencyContactMapper;
import com.yisimeans.mapper.StudentMapper;
import com.yisimeans.pojo.EmergencyContact;
import com.yisimeans.pojo.PageResult;
import com.yisimeans.pojo.Student;
import com.yisimeans.pojo.StudentQueryParam;
import com.yisimeans.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
 * 學生service實現類
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private EmergencyContactMapper emergencyContactMapper;

    @Autowired
    private StudentMapper studentMapper;

    // 查詢學生列表
    @Override
    public PageResult<Student> queryAll(StudentQueryParam studentQueryParam) {
        // 調用pageHelper並設置分頁參數
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        // 調用mapper分頁查詢方法
        List<Student> pageList = studentMapper.queryAll(studentQueryParam);
        // 將返回的pageList轉型為Page對象
        Page<Student> p = (Page<Student>) pageList;
        // 調用Page方法封装查詢結果
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    // 新增學生
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void addStudent(Student student) {
        // 新增學生基本資料
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.addStudent(student);

        // 新增學生緊急聯絡人
        List<EmergencyContact> list = student.getEmergencyContactList();
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(e -> e.setStudentId(student.getId())); // 將自動生成的員工ID賦值給list
            emergencyContactMapper.addContactList(list);
        }
    }

    // 根據ID查詢學生
    @Override
    public Student queryById(Integer id) {
        return studentMapper.queryById(id);
    }

    // 更新學生
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateStudent(Student student) {
        // 更新學生基本資料
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);

        // 刪除緊急聯絡人
        emergencyContactMapper.deleteById(Arrays.asList(student.getId()));

        // 新增緊急聯絡人
        List<EmergencyContact> list = student.getEmergencyContactList();
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(e -> e.setStudentId(student.getId()));
            emergencyContactMapper.addContactList(list);
        }
    }

    // 批量刪除學生
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteByIds(List<Integer> ids) {
        // 刪除學生基本資料
        studentMapper.deleteByIds(ids);

        // 刪除學生緊急聯絡人
        emergencyContactMapper.deleteById(ids);
    }
}
