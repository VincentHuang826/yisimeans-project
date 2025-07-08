package com.yisimeans.service;

import com.yisimeans.exception.CustomExceptions;
import com.yisimeans.pojo.Department;

import java.util.List;

/**
 * 部門service
 */


public interface DepartmentService {

    // 查詢所有部門
    List<Department> queryAll();

    // 刪除部門
    void deleteById(Integer id) throws CustomExceptions;

    // 新增部門
    void addDepartment(Department department);

    // 根據ID查詢部門
    Department queryById(Integer id);

    // 根據ID修改部門
    void updateDepartment(Department department);
}
