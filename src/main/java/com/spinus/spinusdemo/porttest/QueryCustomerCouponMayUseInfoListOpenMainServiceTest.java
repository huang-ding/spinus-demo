package com.spinus.spinusdemo.porttest;

import com.alibaba.fastjson.JSON;
import com.spinus.spinusdemo.base.Base;
import com.spinus.spinusdemo.utils.OkHttpUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author huangding
 * @description
 * @date 2019/5/8 11:04
 */
@Slf4j
public class QueryCustomerCouponMayUseInfoListOpenMainServiceTest {

    public static void main(String[] args) {
        Map<String, String> params =
            Base.getStringStringMap(Base.QUERY_COUPON_MAY_USE_INFO_LIST);
        Map<String, String> data = new HashMap<>(8);
        //用户标识 不可空
        data.put("customerTypeTag","17858449952");
        //用户类型 不可空
        data.put("customerType","1");
        //优惠券模板Id数组 可空
        //data.put("templateIds","ac6d9965-05c7-4012-a828-3672ec7897e5,c2bf0749-19cb-4b52-85ec-8b3ad990e491");
        //商家Id 不可空
        data.put("sellerId","53");
        //门槛金额 不可空
        data.put("minPoint","0");

        params.put("data", JSON.toJSONString(data));
        params.put("sign",Base.getComparedSign(params,Base.APPKEY));
        String post = OkHttpUtil.post(Base.TESTADDRESS, params);
        log.info("--------------------");
        log.info(params.toString());
        log.info(post);

    }
}
