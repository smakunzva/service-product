package com.cakeboss.service.product.exception;

/**
 *
 * @author stevemak
 */
public class Status411ProductNotDeleted extends Exception {
    
    private static final int CODE = 411;
    
    public Status411ProductNotDeleted(String message) {
        super(message);
    }
    
}
