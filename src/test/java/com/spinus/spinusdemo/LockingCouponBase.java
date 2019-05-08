package com.spinus.spinusdemo;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author huangding
 * @description 锁定优惠券 改变状态为使用中base
 * @date 2019/4/19 16:15
 */
public class LockingCouponBase{

    public final static String APPID = "1002";
    public final static String APPKEY = "098f6bcd4621d373cade4e832627b4f6";
    public final static String VERSION = "1.0.0";
    public final static String SELLER_ID = "11";

    /**
     * 请求地址
     */
    public static final String LOCKING_COUPON = "locking_coupon";

    public static Map<String, String> getStringStringMap(String method) {
        Map<String, String> params = new HashMap<>(6);
        params.put("appId",APPID);
        params.put("version", "1.0.0");
        params.put("method", LOCKING_COUPON);
        params.put("timestamp",
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return params;
    }

}
