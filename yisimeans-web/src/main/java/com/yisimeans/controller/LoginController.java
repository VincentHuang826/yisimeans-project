package com.yisimeans.controller;

import com.yisimeans.pojo.Employee;
import com.yisimeans.pojo.LoginInfo;
import com.yisimeans.pojo.Result;
import com.yisimeans.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登入控制類
 */

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    // 使用者登入
    @PostMapping("/login")
    public Result login(@RequestBody Employee employee) {
        log.info("使用者登入: {}", employee);
        LoginInfo loginInfo = employeeService.login(employee);
        if (loginInfo != null) {
            return Result.success(loginInfo);
        } else {
            return Result.error("使用者帳號或密碼錯誤");
        }
    }
}
