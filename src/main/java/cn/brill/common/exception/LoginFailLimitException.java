package cn.brill.common.exception;

import org.springframework.security.authentication.InternalAuthenticationServiceException;

import lombok.Data;

/**
 * @author zhang
 * @date 2020/12/30
 */
@Data
public class LoginFailLimitException extends InternalAuthenticationServiceException {

    private static final long serialVersionUID = 2287298349984709994L;

    private String msg;

    public LoginFailLimitException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public LoginFailLimitException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }
}
