package ua.skillsup.gelius.controller.response;

public enum ResponseCode {

    OK(200),
    NO_CONTENT(204),
    OBJECT_EXISTS(302), //Found
    VALIDATION_ERROR(406), //Not Acceptable
    BAD_DATA(400), //Bad Request (maybe, 415 Unsupported Media Type)
    NOT_FOUND(404),
    FILE_SIZE_EXCEEDED(413), //Request Entity Too Large
    SERVER_ERROR(500);

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
