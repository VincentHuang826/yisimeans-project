package com.yisimeans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 使用者登入類
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    private Integer id; // 主鍵ID
    private String name; // 姓名
    private String username; // 使用者帳號
    private String token; // 令牌
}
