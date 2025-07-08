package com.yisimeans.mapper;

import com.yisimeans.pojo.Student;
import com.yisimeans.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;
import java.util.Map;

/**
 * 學生mapper
 */

@Mapper
public interface StudentMapper {
    // 查詢學生列表
    List<Student> queryAll(StudentQueryParam studentQueryParam);

    // 新增學生
    @Options(useGeneratedKeys = true, keyProperty = "id") // 獲取自動生成的主鍵ID
    @Insert("insert into student(name, number, gender, phone, birthday, address, clazz_id, create_time, update_time) VALUES" +
            "(#{name}, #{number}, #{gender}, #{phone}, #{birthday}, #{address}, #{clazzId}, #{createTime}, #{updateTime})")
    void addStudent(Student student);

    // 根據ID查詢學生
    Student queryById(Integer id);

    // 更新學生
    void updateStudent(Student student);

    // 批量刪除學生
    void deleteByIds(List<Integer> ids);

    // 查詢學生性別統計人數
    @MapKey("name")
    List<Map<String, Object>> getStudentGender();
}
