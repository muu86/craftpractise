package com.mj.craftpractise.domain.model.category;

public class CategoryCreationException extends RuntimeException {

    public CategoryCreationException(String message) {
        super(message);
    }

    public CategoryCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
