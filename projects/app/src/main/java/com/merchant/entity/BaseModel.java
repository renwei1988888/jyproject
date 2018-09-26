package com.merchant.entity;

import java.io.Serializable;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/1416:54
 * desc   : 基础model
 * version: 1.0
 */
public class BaseModel implements Serializable {

    public String code;

    public String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
