package com.yisimeans.service;

import com.yisimeans.pojo.Employee;
import com.yisimeans.pojo.EmployeeQueryParam;
import com.yisimeans.pojo.LoginInfo;
import com.yisimeans.pojo.PageResult;

import java.util.List;

/**
 * 員工service
 */


public interface EmployeeService {
    // 分頁查詢員工
    PageResult<Employee> queryAll(EmployeeQueryParam employeeQueryParam);

    // 新增員工
    void addEmployee(Employee employee);

    // 批量刪除員工
    void deleteByIds(List<Integer> ids);

    // 根據ID查詢員工
    Employee queryById(Integer id);

    // 更新員工
    void updateEmployee(Employee employee);

    // 查詢全部員工
    List<Employee> getEmployeeList();

    // 使用者登入
    LoginInfo login(Employee employee);
}
