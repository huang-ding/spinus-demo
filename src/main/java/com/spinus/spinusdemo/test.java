package com.spinus.spinusdemo;

import com.alibaba.fastjson.JSON;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author huangding
 * @description
 * @date 2019/4/19 16:14
 */
@Slf4j
public class test {

    public static void main(String[] args) {
        Map<String, String> params = Base.getStringStringMap(Base.QUERY_COUPON_INFO_LIST);
        Map<String, String> data = new HashMap<>(8);
        data.put("customerTypeTag", "xxx");
        //customerType = 1.手机号 2.车牌号
        data.put("customerType", "2");
        data.put("sellerId", Base.SELLER_ID);
        //0=未使用 1=已使用 2=使用中 3=已过期，不传查询所有状态
        data.put("useStatus", "0");
        //1=查询当前可使用时间内的
        data.put("useDataType", "1");
        //门槛金额
        data.put("minPoint", "");

        params.put("data", JSON.toJSONString(data));
        params.put("sign", Base.getComparedSign(params, Base.APPKEY));
        String post = OkHttpUtil.post(couponUrl, params);
    }
}
