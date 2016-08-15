package ua.skillsup.gelius.model;

public enum ResponseCode {

    ERROR(0), //ошибка общая
    OK(1), //выполнено
    NO_DATA(2), //ничего не найдено
    VALIDATION_ERROR(3) //ошибки валидации
    //OBJECT_EXISTS(4), //объект уже существует
    //OBJECT_NOT_EXISTS(5) //объект не существует
    ;

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
