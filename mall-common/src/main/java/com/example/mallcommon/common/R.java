package com.example.mallcommon.common;

public class R<T> {

    private static final String SUCCESS_MESSAGE = "success";
    private static final String ERROR_MESSAGE = "error";

    private int code;
    private String message;
    private T data;

    private R() {}

    private R(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> R<T> success() {
        return new R<>(200, SUCCESS_MESSAGE, null);
    }

    public static <T> R<T> success(T data) {
        return new R<>(200, SUCCESS_MESSAGE, data);
    }

    public static <T> R<T> error() {
        return new R<>(500, ERROR_MESSAGE, null);
    }

    public static <T> R<T> error(String message) {
        return new R<>(500, message, null);
    }

    public static <T> R<T> error(int code, String message) {
        return new R<>(code, message, null);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
