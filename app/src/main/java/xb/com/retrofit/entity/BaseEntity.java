package xb.com.retrofit.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/16.
 */
public class BaseEntity implements Serializable {
    String message;
    String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("message").append("=").append(message).append("\n")
                .append("code").append("=").append(code)
                .toString();
    }
}
