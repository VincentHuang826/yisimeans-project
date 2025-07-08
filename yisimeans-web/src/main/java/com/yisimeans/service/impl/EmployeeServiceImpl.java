package com.yisimeans.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yisimeans.mapper.CertificatesMapper;
import com.yisimeans.mapper.EmployeeMapper;
import com.yisimeans.pojo.*;
import com.yisimeans.service.EmployeeService;
import com.yisimeans.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 員工service實現類
 */

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private CertificatesMapper certificatesMapper;

    // 分頁查詢員工
    @Override
    public PageResult<Employee> queryAll(EmployeeQueryParam employeeQueryParam) {
        // 調用pageHelper並設置分頁參數
        PageHelper.startPage(employeeQueryParam.getPage(), employeeQueryParam.getPageSize());
        // 調用mapper分頁查詢方法
        List<Employee> pageList = employeeMapper.queryAll(employeeQueryParam);
        // 將返回的pageList轉型為Page對象
        Page<Employee> p = (Page<Employee>) pageList;
        // 調用Page方法封装查詢結果
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    // 新增員工
    @Transactional(rollbackFor = {Exception.class}) // 開啟事務管理 - 所有異常皆回滾
    @Override
    public void addEmployee(Employee employee) {
        // 新增員工基本資料
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employeeMapper.addEmployee(employee);

        // 新增員工證照
        List<Certificates> certificatesList = employee.getCertificatesList();
        if (!CollectionUtils.isEmpty(certificatesList)) {
            certificatesList.forEach(cer -> cer.setEmployeeId(employee.getId())); // 將自動生成的員工ID賦值給certificatesList
            certificatesMapper.addCertificates(certificatesList);
        }
    }

    // 批量刪除員工
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteByIds(List<Integer> ids) {
        // 刪除員工基本資料
        employeeMapper.deleteByIds(ids);

        // 刪除員工證照
        certificatesMapper.deleteByEmployeeIds(ids);
    }

    // 根據ID查詢員工
    @Override
    public Employee queryById(Integer id) {
        return employeeMapper.queryById(id);
    }

    // 更新員工
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateEmployee(Employee employee) {
        // 更新員工基本資料
        employee.setUpdateTime(LocalDateTime.now());
        employeeMapper.updateEmployee(employee);

        // 刪除員工舊有證照資料
        certificatesMapper.deleteByEmployeeIds(Arrays.asList(employee.getId()));

        // 新增修改後的證照資料
        List<Certificates> certificatesList = employee.getCertificatesList();
        if (!CollectionUtils.isEmpty(certificatesList)) {
            certificatesList.forEach(cer -> {cer.setEmployeeId(employee.getId());});
            certificatesMapper.addCertificates(certificatesList);
        }
    }

    // 查詢全部員工
    @Override
    public List<Employee> getEmployeeList() {
        return employeeMapper.getEmployeeList();
    }

    // 使用者登入
    @Override
    public LoginInfo login(Employee employee) {
        Employee user = employeeMapper.login(employee);

        if (user != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("username", user.getUsername());
            String token = JwtUtil.generateJwt(claims);
            log.info("登入成功: {}, token: {}", user, token);
            return new LoginInfo(user.getId(), user.getName(), user.getUsername(), token);
        } else {
            return null;
        }
    }
}
