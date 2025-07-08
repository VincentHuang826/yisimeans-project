package com.yisimeans.mapper;

import com.yisimeans.pojo.Certificates;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 證照操作mapper
 */

@Mapper
public interface CertificatesMapper {

    // 新增員工證照
    void addCertificates(List<Certificates> certificatesList);

    // 刪除員工證照
    void deleteByEmployeeIds(List<Integer> employeeIds);
}
