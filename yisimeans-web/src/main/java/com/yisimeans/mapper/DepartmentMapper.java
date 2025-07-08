package com.yisimeans.mapper;

import com.yisimeans.pojo.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部門操作mapper
 */

@Mapper
public interface DepartmentMapper {

    // 查詢所有部門
    @Select("select id, name, create_time, update_time from department order by update_time desc")
    List<Department> queryAll();

    // 刪除部門
    @Delete("delete from department where id = #{id}")
    void deleteById(Integer id);

    // 新增部門
    @Insert("insert into department(name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime})")
    void addDepartment(Department department);

    // 根據ID查詢部門
    @Select("select id, name, create_time, update_time from department where id = #{id}")
    Department queryById(Integer id);

    // 根據ID修改部門
    @Update("update department set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void updateDepartment(Department department);

    // 檢查部門是否還有員工
    @Select("select count(*) from employee e left join department d on e.department_id = d.id where e.department_id = #{id}")
    Integer checkPerson(Integer id);
}
