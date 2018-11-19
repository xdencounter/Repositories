package com.baiyun.common.Utils;

import com.alibaba.fastjson.JSONObject;

public class JsonRequest extends JsonMessage {

    /**
     * 默认构造函数
     */
    public JsonRequest() {
        super();
    }

    /**
     * 构造函数
     *
     * @param header
     * @param data
     */
    public JsonRequest(JSONObject header, JSONObject data) {
        super(header, data);
    }
}