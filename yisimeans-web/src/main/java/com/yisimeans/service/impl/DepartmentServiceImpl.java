package com.yisimeans.service.impl;

import com.yisimeans.exception.CustomExceptions;
import com.yisimeans.mapper.DepartmentMapper;
import com.yisimeans.pojo.Department;
import com.yisimeans.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 部門service實現類
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    // 查詢所有部門
    @Override
    public List<Department> queryAll() {
        return departmentMapper.queryAll();
    }

    // 刪除部門
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteById(Integer id) throws CustomExceptions {
        // 檢查部門是否還有員工
        Integer person = departmentMapper.checkPerson(id);

        if (person == 0) {
            // 調用刪除方法
            departmentMapper.deleteById(id);
        } else {
            throw new CustomExceptions("無法刪除部門，該部門尚有" + person + "位員工");
        }
    }

    // 新增部門
    @Override
    public void addDepartment(Department department) {
        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());
        departmentMapper.addDepartment(department);
    }

    // 根據ID查詢部門
    @Override
    public Department queryById(Integer id) {
        return departmentMapper.queryById(id);
    }

    // 根據ID修改部門
    @Override
    public void updateDepartment(Department department) {
        department.setUpdateTime(LocalDateTime.now());
        departmentMapper.updateDepartment(department);
    }
}
