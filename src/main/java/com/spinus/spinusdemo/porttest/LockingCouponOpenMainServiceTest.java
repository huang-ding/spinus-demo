package com.spinus.spinusdemo.porttest;

import com.alibaba.fastjson.JSON;
import com.spinus.spinusdemo.base.Base;
import com.spinus.spinusdemo.utils.OkHttpUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wuyongsheng
 * @descriptio 锁定优惠券(locking_coupon)(当优惠券状态为0时，把优惠券状态改为2)
 * @date 2019/4/19 21:24
 **/
@Slf4j
public class LockingCouponOpenMainServiceTest {
    public static void main(String[] args) {
        Map<String, String> params =
            Base.getStringStringMap(Base.LOCKING_COUPON);
        Map<String, String> data = new HashMap<>(8);
        //couponId	优惠券Id
        data.put("couponId","194b9785-4dae-4a01-bf88-fbfcbfe76708");
        //type	核销类型
        data.put("type","1");
        //amount	消费金额
        data.put("amount","2000");

        params.put("data", JSON.toJSONString(data));
        params.put("sign",Base.getComparedSign(params,Base.APPKEY));
        String post = OkHttpUtil.post(Base.TESTADDRESS, params);
        log.info(post);
        log.info("--------------------");
        log.info(params.toString());
    }
}
