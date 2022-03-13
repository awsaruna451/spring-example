package com.aruna.dao;

public class ApiResponse {
    private boolean success;
    private Object data;
    private ApiError error;

    public ApiResponse(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public ApiResponse(Boolean success, ApiError apiError) {
        this.success = success;
        this.error = apiError;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }
}
