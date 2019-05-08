package com.spinus.spinusdemo.porttest;


import com.alibaba.fastjson.JSON;
import com.spinus.spinusdemo.base.Base;
import com.spinus.spinusdemo.utils.OkHttpUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wuyongsheng
 * @description 解锁优惠券(unlock_coupon)(当优惠券状态为2时，把优惠券状态改为0)
 * @date 2019/4/19 21:26
 **/
@Slf4j
public class UnlockCouponMainServiceTest {
    public static void main(String[] args) {
        Map<String, String> params =
            Base.getStringStringMap(Base.UNLOCK_COUPON);
        Map<String, String> data = new HashMap<>(8);
        data.put("couponId","194b9785-4dae-4a01-bf88-fbfcbfe76708");

        params.put("data", JSON.toJSONString(data));
        params.put("sign",Base.getComparedSign(params,Base.APPKEY));
        String post = OkHttpUtil.post(Base.TESTADDRESS, params);
        log.info(post);
        log.info("--------------------");
        log.info(params.toString());
    }
}
