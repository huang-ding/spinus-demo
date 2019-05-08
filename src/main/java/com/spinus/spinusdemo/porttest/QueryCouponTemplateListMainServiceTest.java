package com.spinus.spinusdemo.porttest;

import com.alibaba.fastjson.JSON;
import com.spinus.spinusdemo.base.Base;
import com.spinus.spinusdemo.utils.OkHttpUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wuyongsheng
 * @description 查询指定商家优惠券模板列表
 * @date 2019/4/19 21:25
 **/
@Slf4j
public class QueryCouponTemplateListMainServiceTest {

    public static void main(String[] args) {
        Map<String, String> params =
            Base.getStringStringMap(Base.QUERY_COUPON_TEMPLATE_LIST);
        Map<String, String> data = new HashMap<>(8);
        /**
         * 商家id
         */
        data.put("sellerId","53");

        params.put("data", JSON.toJSONString(data));
        params.put("sign",Base.getComparedSign(params,Base.APPKEY));
        String post = OkHttpUtil.post(Base.TESTADDRESS, params);
        log.info(post);
        log.info("--------------------");
        log.info(params.toString());
    }
}
