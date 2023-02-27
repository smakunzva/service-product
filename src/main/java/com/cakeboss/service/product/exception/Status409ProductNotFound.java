package com.cakeboss.service.product.exception;

import lombok.Getter;

/**
 *
 * @author stevemak
 */
@Getter
public class Status409ProductNotFound extends Exception {
    
    private static final int CODE = 409;
    public Status409ProductNotFound(String message) {
        super(message);
    }
}
