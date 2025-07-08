package com.yisimeans.mapper;

import com.yisimeans.pojo.Employee;
import com.yisimeans.pojo.EmployeeQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 員工操作mapper
 */

@Mapper
public interface EmployeeMapper {

    // 分頁查詢員工
    List<Employee> queryAll(EmployeeQueryParam employeeQueryParam);

    // 新增員工
    @Options(useGeneratedKeys = true, keyProperty = "id") // 獲取自動生成的主鍵ID
    @Insert("insert into employee(name, username, gender, phone, email, birthday, address, salary, department_id, position, start_date, create_time, update_time) VALUES " +
            "(#{name}, #{username}, #{gender}, #{phone}, #{email}, #{birthday}, #{address}, #{salary}, #{departmentId}, #{position}, #{startDate}, #{createTime}, #{updateTime})")
    void addEmployee(Employee employee);

    // 批量刪除員工
    void deleteByIds(List<Integer> ids);

    // 根據ID查詢員工
    Employee queryById(Integer id);

    // 更新員工
    void updateEmployee(Employee employee);

    // 查詢員工職位統計人數
    @MapKey("position")
    List<Map<String, Object>> getEmployeePosition();

    // 查詢員工性別統計人數
    @MapKey("name")
    List<Map<String, Object>> getEmployeeGender();

    // 查詢全部員工
    @Select("select id, name, username, password, gender, phone, email, birthday, address, salary, department_id, position, start_date, create_time, update_time from employee")
    List<Employee> getEmployeeList();

    // 使用者登入
    @Select("select id, name, username from employee where username = #{username} and password = #{password}")
    Employee login(Employee employee);
}
