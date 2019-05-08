package com.spinus.spinusdemo.utils;

import java.util.Map;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

/**
 * @author wuyongsheng
 * @description
 * @date 2019/4/19 19:48
 **/
public class OkHttpUtil {
    /**
     * post
     *
     * @param url 请求的url
     * @param params post form 提交的参数
     */
    public static String post(String url, Map<String, String> params) {
        FormBody.Builder builder = new FormBody.Builder();
        //添加参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder()
            .url(url)
            .post(builder.build())
            .build();
        return responseHandle(request);
    }


    private static String responseHandle(Request request) {
        Response response = null;
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return StringUtils.EMPTY;
    }
}
