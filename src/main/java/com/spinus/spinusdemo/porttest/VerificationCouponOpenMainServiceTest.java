package com.spinus.spinusdemo.porttest;


import com.alibaba.fastjson.JSON;
import com.spinus.spinusdemo.base.Base;
import com.spinus.spinusdemo.utils.OkHttpUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author huangding
 * @description 1.3.7核销(verification_coupon)
 * @date 2019/4/19 16:14
 */
@Slf4j
public class VerificationCouponOpenMainServiceTest {

    public static void main(String[] args) {
        Map<String, String> params =
            Base.getStringStringMap(Base.VERIFICATION_COUPON);
        Map<String, String> data = new HashMap<>(8);
        //优惠券id 不可空
        data.put("couponId","194b9785-4dae-4a01-bf88-fbfcbfe76708");
        //核销类型 不可空
        data.put("type","2");
        //消费金额 可空
        data.put("amount","20");

        params.put("data", JSON.toJSONString(data));
        params.put("sign",Base.getComparedSign(params,Base.APPKEY));
        String post = OkHttpUtil.post(Base.TESTADDRESS, params);
        log.info(post);
        log.info("--------------------");
        log.info(params.toString());
    }
}
