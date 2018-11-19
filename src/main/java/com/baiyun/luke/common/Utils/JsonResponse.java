package com.baiyun.common.Utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class JsonResponse extends JsonMessage {

    /**
     * 默认构造函数
     */
    public JsonResponse() {
        super();
    }

    /**
     * 构造函数
     *
     * @param header
     * @param data
     */
    public JsonResponse(JSONObject header, JSONObject data) {
        super(header, data);
    }

    /**
     * 设置响应码
     *
     * @return
     */
    public String getRetCode() {
        return (String) super.getHeader("retCode");
    }

    public void setRetCode(Object object) {
        super.setHeader("retCode", object);
    }

    public String getRetMsg() {
        return (String) super.getHeader("retMsg");
    }

    public void setRetMsg(String retMsg) {
        super.setHeader("retMsg", retMsg);
    }

    /**
     *
     * @param result
     * @return
     */
    public static JsonResponse formatFromBsp(Map<String, Object> result) {
        JsonResponse response = new JsonResponse();
        response.setData(new JSONObject(result));
        return response;
    }
}