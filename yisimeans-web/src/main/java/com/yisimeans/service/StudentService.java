package com.yisimeans.service;

import com.yisimeans.pojo.PageResult;
import com.yisimeans.pojo.Student;
import com.yisimeans.pojo.StudentQueryParam;

import java.util.List;

/**
 * 學生service
 */


public interface StudentService {
    // 查詢學生列表
    PageResult<Student> queryAll(StudentQueryParam studentQueryParam);

    // 新增學生
    void addStudent(Student student);

    // 根據ID查詢學生
    Student queryById(Integer id);

    // 更新學生
    void updateStudent(Student student);

    // 批量刪除學生
    void deleteByIds(List<Integer> ids);
}
