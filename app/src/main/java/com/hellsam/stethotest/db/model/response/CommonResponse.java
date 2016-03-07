package com.hellsam.stethotest.db.model.response;

/**
 * Created by binshenchen on 16/3/4.
 */
public class CommonResponse {
    protected int errNum;
    protected String errMsg;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
