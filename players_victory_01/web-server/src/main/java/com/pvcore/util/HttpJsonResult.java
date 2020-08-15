package com.pvcore.util;

import java.io.Serializable;
import java.util.Date;

public class HttpJsonResult<T> implements Serializable {
    private Boolean success = true;

    private Date systemTime;

    private T data;

    private String message;

    private String errorCode;

    private Integer totalCount = 0;

    public HttpJsonResult(T data) {
        this.data = data;
        this.message = "";
        this.errorCode = "";
        this.systemTime = new Date();
    }

    public void setError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.message = errorMessage;
        this.success = false;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Date getSystemTime() {
        return systemTime;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Integer getTotalCount() {
        return totalCount;
    }
}
