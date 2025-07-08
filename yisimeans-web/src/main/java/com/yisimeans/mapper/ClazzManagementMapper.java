package com.yisimeans.mapper;

import com.yisimeans.pojo.Clazz;
import com.yisimeans.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 班級管理mapper
 */

@Mapper
public interface ClazzManagementMapper {

    // 分頁查詢班級列表
    List<Clazz> queryAll(ClazzQueryParam clazzQueryParam);

    // 新增班級
    @Insert("insert into clazz(name, room, begin_date, end_date, teacher_id, create_time, update_time) VALUES" +
            "(#{name}, #{room}, #{beginDate}, #{endDate}, #{teacherId}, #{createTime}, #{updateTime})")
    void addClazz(Clazz clazz);

    // 根據ID查詢班級
    @Select("select id, name, room, begin_date, end_date, teacher_id, create_time, update_time from clazz where id = #{id}")
    Clazz queryById(Integer id);

    // 更新班級
    void updateClazz(Clazz clazz);

    // 刪除班級
    @Delete("delete from clazz where id = #{id}")
    void deleteClazz(Integer id);

    // 檢查班級是否還有學生
    @Select("select count(*) from student s left join clazz c on s.clazz_id = c.id where s.clazz_id = #{id}")
    Integer checkPerson(Integer id);

    // 查詢所有班級
    @Select("select id, name, room, begin_date, end_date, teacher_id, create_time, update_time from clazz")
    List<Clazz> getClazzList();

    // 查詢班級學生統計人數
    @MapKey("clazz")
    List<Map<String, Object>> getClazzCount();
}
