package com.diego.shared;

public interface Id<T> {
    public static String NULL_ID = "id is null";
    public static String EMPTY_ID = "id is null";
    public static String INVALID_ID = "id is invalid";

    T value();
}
