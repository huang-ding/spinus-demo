package com.spinus.spinusdemo.porttest;


import com.alibaba.fastjson.JSON;
import com.spinus.spinusdemo.base.Base;
import com.spinus.spinusdemo.utils.OkHttpUtil;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wuyongsheng
 * @description 查询当前服务商商家列表(query_seller_list)
 * @date 2019/4/19 21:25
 **/
@Slf4j
public class QuerySellerListMainServiceTest {

    public static void main(String[] args) {
        Map<String, String> params =
            Base.getStringStringMap(Base.QUERY_SELLER_LIST);
        Map<String, String> data = new HashMap<>(8);
        data.put("cityCode","310100");
        data.put("provinceCode","310000");
        data.put("areaCode","330204");
        data.put("tel","13058857770");

        params.put("data", JSON.toJSONString(data));
        params.put("sign",Base.getComparedSign(params,Base.APPKEY));
        String post = OkHttpUtil.post(Base.TESTADDRESS, params);
        log.info("返回结果："+post);
        log.info("--------------------");
        log.info("请求参数："+params.toString());
    }
}
