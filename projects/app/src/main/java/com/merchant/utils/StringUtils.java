package com.merchant.utils;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/618:04
 * desc   :
 * version: 1.0
 */
public class StringUtils {

    public boolean isEmyptOrNull(String str){
        if(str.endsWith("") || str.length() == 0 || str == null)
            return true;
        else
            return  false;
    }
}
