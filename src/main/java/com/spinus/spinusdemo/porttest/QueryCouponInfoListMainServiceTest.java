package com.spinus.spinusdemo.porttest;


import com.alibaba.fastjson.JSON;
import com.spinus.spinusdemo.base.Base;
import com.spinus.spinusdemo.utils.OkHttpUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wuyongsheng
 * @description 1.3.3查询指定用户账户优惠券信息(query_coupon_info_list)
 * @date 2019/4/19 21:25
 **/
@Slf4j
public class QueryCouponInfoListMainServiceTest {
    public static void main(String[] args) {
        Map<String, String> params =
            Base.getStringStringMap(Base.QUERY_COUPON_INFO_LIST);
        Map<String, String> data = new HashMap<>(8);
        //用户标识 不可空
        data.put("customerTypeTag","18888888888");
        //用户类型 不可空
        data.put("customerType","1");
        //优惠券模板Id数组 可空
        //data.put("templateIds","75,76,82,89,83,87");
        //商家Id 不可空
        data.put("sellerId","53");
        //使用状态 可空
        //data.put("useStatus","0");
        //门槛金额 可空
        data.put("minPoint","10000");
        //使用时间类型 可空
        //data.put("useDataType","1");

        params.put("data", JSON.toJSONString(data));
        params.put("sign",Base.getComparedSign(params,Base.APPKEY));
        String post = OkHttpUtil.post(Base.TESTADDRESS, params);
        log.info(post);
        log.info("--------------------");
        log.info(params.toString());
    }
}
