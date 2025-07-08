package com.yisimeans.mapper;

import com.yisimeans.pojo.EmergencyContact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 學生緊急聯絡人mapper
 */

@Mapper
public interface EmergencyContactMapper {
    // 新增學生緊急聯絡人
    void addContactList(List<EmergencyContact> list);

    // 刪除學生緊急聯絡人
    void deleteById(List<Integer> ids);
}
