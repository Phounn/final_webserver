package web.group.two.common.exception.dto;

import lombok.Getter;
import web.group.two.common.exception.ErrorCode;

@Getter
public class ErrorResponse {
    private final Integer errorCode;
    private final String message;

    public ErrorResponse(ErrorCode errorCode){
        this.errorCode = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
