package com.spinus.spinusdemo.porttest;


import com.alibaba.fastjson.JSON;
import com.spinus.spinusdemo.base.Base;
import com.spinus.spinusdemo.utils.OkHttpUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wuyongsheng
 * @description 领取，发放优惠券(receive_coupon)
 * @date 2019/4/19 21:26
 **/
@Slf4j
public class ReceiveCouponMainServiceTest {
    public static void main(String[] args) {
        Map<String, String> params =
            Base.getStringStringMap(Base.RECEIVE_COUPON);
        Map<String, String> data = new HashMap<>(8);
        //用户标识 不可空
        data.put("customerTypeTag","18888888888");
        //用户类型 不可空
        data.put("customerType","1");
        //优惠券模板Id 不可空
        data.put("templateId","ac6d9965-05c7-4012-a828-3672ec7897e5");
        //商家Id 不可空
        data.put("sellerId","53");

        params.put("data", JSON.toJSONString(data));
        params.put("sign",Base.getComparedSign(params,Base.APPKEY));
        String post = OkHttpUtil.post(Base.TESTADDRESS, params);
        log.info(post);
        log.info("--------------------");
        log.info(params.toString());
    }
}
