package ua.skillsup.gelius.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Response {
    private int code;
    private long objectId;
    @JsonIgnore
    private ResponseCode codeEnum;

    public Response(ResponseCode responseCode) {
        this.codeEnum = responseCode;
        this.code = responseCode.getCode();
    }

    public Response(ResponseCode responseCode, long objectId) {
        this(responseCode);
        this.objectId = objectId;
    }

    public int getCode() {
        return code;
    }

    public long getObjectId() {
        return objectId;
    }

    /*public ResponseCode getCodeEnum() {
        return codeEnum;
    }*/

}
