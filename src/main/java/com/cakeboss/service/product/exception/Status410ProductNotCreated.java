package com.cakeboss.service.product.exception;

import lombok.Getter;

/**
 *
 * @author stevemak
 */
@Getter
public class Status410ProductNotCreated extends Exception {
    
    private static final int CODE = 410;
    
    public Status410ProductNotCreated(String message) {
        super(message);
    }
    
}
