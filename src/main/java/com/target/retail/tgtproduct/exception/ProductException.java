package com.target.retail.tgtproduct.exception;

/**
 * @author abhilasha
 * @since 21/11/19
 */

public class ProductException extends RuntimeException {

    private Integer errorCode = null;

    public ProductException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;

    }
}
