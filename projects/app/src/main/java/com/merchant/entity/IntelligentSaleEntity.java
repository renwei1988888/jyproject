package com.merchant.entity;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/1815:12
 * desc   :  智能售卖model
 * version: 1.0
 */
public class IntelligentSaleEntity extends BaseModel {
    public String pro_name;
    public Boolean ishot;
    public String pro_mark;
    public String pro_price;

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public Boolean getIshot() {
        return ishot;
    }

    public void setIshot(Boolean ishot) {
        this.ishot = ishot;
    }

    public String getPro_mark() {
        return pro_mark;
    }

    public void setPro_mark(String pro_mark) {
        this.pro_mark = pro_mark;
    }

    public String getPro_price() {
        return pro_price;
    }

    public void setPro_price(String pro_price) {
        this.pro_price = pro_price;
    }
}
