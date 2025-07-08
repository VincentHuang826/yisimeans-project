package com.yisimeans.pojo;

import lombok.Data;

/**
 * 統一響應結果類
 */

@Data
public class Result {
    private Integer code; // 1.成功 0. 失敗
    private String msg; // 返回訊息
    private Object data; // 返回參數

    // 成功響應 - 無返回參數
    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    // 成功響應 - 有返回參數
    public static Result success(Object object) {
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        result.data = object;
        return result;
    }

    // 失敗響應 - 返回錯誤訊息
    public static Result error(String msg) {
        Result result = new Result();
        result.code = 0;
        result.msg = msg;
        return result;
    }
}
