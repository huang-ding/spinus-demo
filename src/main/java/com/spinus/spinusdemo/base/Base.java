package com.spinus.spinusdemo.base;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wuyongsheng
 * @description
 * @date 2019/4/20 10:05
 **/
@Slf4j
public class Base {

    public final static String APPID = "1002";
    public final static String APPKEY = "098f6bcd4621d373cade4e832627b4f6";
    public final static String VERSION = "1.0.0";
    /**
     * 测试地址
     */
//    public final static String TESTADDRESS = "http://192.168.110.180/open/gateway";
    public final static String TESTADDRESS = "http://dev.spinus.saopay.net/open/gateway";
    /**
     * 锁定优惠券 改变状态为使用中接口名称
     */
    public final static String LOCKING_COUPON = "locking_coupon";

    /**
     * 查询指定用户账户优惠券信息接口名称
     */
    public final static String QUERY_COUPON_INFO_LIST = "query_coupon_info_list";

    /**
     * 查询指定用户账户优惠券信息可使用接口名称
     */
    public final static String QUERY_COUPON_MAY_USE_INFO_LIST = "query_coupon_may_use_info_list";

    /**
     * 请求地址
     */
    public static final String QUERY_COUPON_TEMPLATE_LIST = "query_coupon_template_list";

    /**
     * 查询当前服务商商家列表接口名称
     */
    public final static String QUERY_SELLER_LIST = "query_seller_list";

    /**
     * 领取优惠券接口名称
     */
    public final static String RECEIVE_COUPON = "receive_coupon";

    /**
     * 解锁优惠券接口名称
     */
    public final static String UNLOCK_COUPON = "unlock_coupon";

    /**
     * 请求地址接口名称
     */
    public final static String VERIFICATION_COUPON = "verification_coupon";


    /**
     * 传入需要测试的接口地址
     *
     * @param method 接口地址名
     */
    public static Map<String, String> getStringStringMap(String method) {
        Map<String, String> params = new HashMap<>(6);
        //params.put("appKey",)
        params.put("version", VERSION);
        params.put("method", method);
        params.put("timestamp",
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        params.put("appId", APPID);
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
        log.info(string);
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
