package com.merchant.constants;

/**
 * author : renwei
 * e-mail : 825497903@qq.com
 * date   : 2018/9/710:45
 * desc   : 常量工具类
 * version: 1.0
 */
public class Constants {
    /* 配置当前的支付环境是测试还是正式*/
    public final static boolean ISREALPAY = false;

    /* 当前系统标志*/
    public final static String CLIENT_TYPE = "android";

    /*控制当前接口是本地测试接口还是现网环境接口,true：现网；false：本地 */
    public static boolean isReleaseVersion = false;

    /*MD5加密用秘钥*/
    public static String encryption_key = "sKnc46B3$D68a#4e8F@aB7v^2cQd3cEb47b9";

    /*接口地址*/
    public static String Common_URL = "";

    static {
        if (isReleaseVersion) {
            Common_URL = "http://192.168.1.170";
        } else {
            Common_URL = "http://192.168.1.170";
        }
    }

    /*结果码-成功*/
    public static int SUCCESS = 200;

    /*结果码-失败*/
    public static int FAIL = 100;

    /*登录*/
    public static String LOGIN_URL = Common_URL + "/mall/public/api/login/member_login";

    // request参数
    public static final int REQ_QR_CODE = 11002; // // 打开扫描界面请求码
    public static final int REQ_PERM_CAMERA = 11003; // 打开摄像头

    public static final String INTENT_EXTRA_KEY_QR_SCAN = "qr_scan_result";



}
