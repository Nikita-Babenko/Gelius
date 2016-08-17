package ua.skillsup.gelius.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Response {
    private int code;
    private Object data;
    @JsonIgnore
    private ResponseCode codeEnum;

    public Response(ResponseCode responseCode) {
        this.codeEnum = responseCode;
        this.code = responseCode.getCode();
    }

    public Response(ResponseCode responseCode, Object data) {
        this(responseCode);
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public ResponseCode getCodeEnum() {
        return codeEnum;
    }

}
