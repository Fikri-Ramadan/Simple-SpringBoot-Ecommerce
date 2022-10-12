package com.fikritech.ecommerce.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {

    private Boolean status = Boolean.TRUE;
    private String message = "Success";
    private T data;

    public BaseResponse(T data) {
        this.data = data;
    }

    public BaseResponse(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

}
