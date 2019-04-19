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
 * @description
 * @date 2019/4/19 16:15
 */
public class Base {


    public final static String COUPON_URL = "http://dev.spinus.saopay.net/open/gateway";
    public final static String APPID = "1002";
    public final static String APPKEY = "098f6bcd4621d373cade4e832627b4f6";
    public final static String VERSION = "1.0.0";
    public final static String SELLER_ID = "11";

    /**
     * 查询指定用户账户优惠券信息
     */
    public final static String QUERY_COUPON_INFO_LIST = "query_coupon_info_list";
    /**
     * 核销
     */
    public final static String VERIFICATION_COUPON = "verification_coupon";


    public static Map<String, String> getStringStringMap(String method) {
        Map<String, String> params = new HashMap<>(6);
        params.put("appId", APPID);
        params.put("version", VERSION);
        params.put("method", method);
        params.put("timestamp",
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return params;
    }


    /**
     * 获取对比的sign
     */
    public static String getComparedSign(Map<String, String> params, String key) {
        StringBuilder sb = new StringBuilder();
        //排序
        List<Entry<String, String>> infoIds = new ArrayList<>(params.entrySet());
        infoIds.sort(Comparator.comparing(Entry::getKey));
        //对参数数组进行按key升序排列,然后拼接，最后调用m5签名方法
        for (Entry<String, String> entry : infoIds) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        String string = sb.append("key=").append(key.trim()).toString();
        return encryptWithMD5(string, "UTF-8");
    }


    /**
     * 使用md5算法进行加密
     *
     * @param target 要加密的字符串
     * @param charset 编码（请设置为UTF-8)
     * @return 加密后的字符串
     */
    public static String encryptWithMD5(String target, String charset) {
        String md5Str = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            byte[] bytes = md5
                .digest(charset == null ? target.getBytes() : target.getBytes(charset));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                int bt = b & 0xff;
                if (bt < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(bt));
            }
            md5Str = sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return md5Str;
    }

}
