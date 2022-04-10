package com.mj.craftpractise.domain.model.goods;

public class GoodsCreationException extends RuntimeException {

    public GoodsCreationException(String message) {
        super(message);
    }

    public GoodsCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
