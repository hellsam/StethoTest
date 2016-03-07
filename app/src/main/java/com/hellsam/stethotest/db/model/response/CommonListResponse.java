package com.hellsam.stethotest.db.model.response;

import java.util.List;

/**
 * Created by binshenchen on 16/3/4.
 */
public class CommonListResponse<T> extends CommonResponse {
    private List<T> ts;

    public List<T> getTs() {
        return ts;
    }

    public void setTs(List<T> ts) {
        this.ts = ts;
    }
}
