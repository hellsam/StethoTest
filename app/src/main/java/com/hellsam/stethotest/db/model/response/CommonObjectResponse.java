package com.hellsam.stethotest.db.model.response;

/**
 * Created by binshenchen on 16/3/4.
 */
public class CommonObjectResponse<T> extends CommonResponse {
    private T retData;

    public T getRetData() {
        return retData;
    }

    public void setRetData(T retData) {
        this.retData = retData;
    }
}
