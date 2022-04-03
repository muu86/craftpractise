package com.mj.craftpractise.web.result;

import java.util.HashMap;

public class ApiResult extends HashMap<String, Object> {

    private static final String MESSAGE_KEY = "message";
    private static final String ERROR_CODE_KEY = "errorCode";

    private ApiResult() {}

    public static ApiResult blank() {
        return new ApiResult();
    }

    public static ApiResult message(String message) {
        ApiResult apiResult = new ApiResult();
        apiResult.put(MESSAGE_KEY, message);
        return apiResult;
    }

    public ApiResult add(String key, Object value) {
        this.put(key, value);
        return this;
    }
}
