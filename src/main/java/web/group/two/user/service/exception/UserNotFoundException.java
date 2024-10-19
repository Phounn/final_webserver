package web.group.two.user.service.exception;

import web.group.two.common.exception.BusinessLogicException;
import web.group.two.common.exception.ErrorCode;

public class UserNotFoundException extends BusinessLogicException {
    public UserNotFoundException() {
        super(ErrorCode.NOT_FOUND_USER);
    }
}
