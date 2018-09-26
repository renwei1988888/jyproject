package com.merchant.entity;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/1814:35
 * desc   : 赚钱赏金entity
 * version: 1.0
 */
public class EarnRewardEntity extends BaseModel {

    public String shopname;
    public String rewardamount;

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getRewardamount() {
        return rewardamount;
    }

    public void setRewardamount(String rewardamount) {
        this.rewardamount = rewardamount;
    }

    @Override
    public String toString() {
        return "EarnRewardEntity{" +
                "shopname='" + shopname + '\'' +
                ", rewardamount='" + rewardamount + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
