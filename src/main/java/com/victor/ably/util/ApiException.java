package com.victor.ably.util;

import com.victor.ably.constants.CommonErrorCode;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    private CommonErrorCode error;

    public ApiException(CommonErrorCode e) {
        super(e.getMessage());
        this.error = e;
    }
}
