package com.yisimeans.mapper;

import com.yisimeans.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 日誌mapper
 */

@Mapper
public interface OperateLogMapper {

    // 紀錄日誌
    @Insert({"insert into operate_log(operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) VALUES(#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})"})
    void insert(OperateLog operateLog);

    // 查詢日誌列表
    @Select("select id, operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time from operate_log order by operate_time desc")
    List<OperateLog> queryLog();
}
