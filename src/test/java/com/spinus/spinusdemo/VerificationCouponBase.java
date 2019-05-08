package com.spinus.spinusdemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuyongsheng
 * @description 核销
 * @date 2019/4/19 20:17
 **/
public class VerificationCouponBase {


    public final static String APPID = "1002";
    public final static String APPKEY = "098f6bcd4621d373cade4e832627b4f6";
    public final static String VERSION = "1.0.0";
    public final static String SELLER_ID = "11";

    /**
     * 请求地址
     */
    public final static String VERIFICATION_COUPON = "verification_coupon";


    /**
     * 锁定优惠券 改变状态为使用中
     */
    public final static String LOCKING_COUPON = "locking_coupon";


    public static Map<String, String> getStringStringMap(String method) {
        Map<String, String> params = new HashMap<>(6);
        params.put("appId", APPID);
        params.put("version", VERSION);
        params.put("method", method);
        params.put("timestamp",
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return params;
    }

}
