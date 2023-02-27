package com.cakeboss.service.product.data;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 *
 * @author stevemak
 */
@ApplicationScoped
@Transactional
//@Slf4j
public class ProductDto {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public Product findProduct(Long productId) {
        return entityManager.find(Product.class, productId);
    }
    
    public boolean createUpadteProduct(Product product) {
        boolean success = false;
        try {
            entityManager.persist(product);
            success = true;
        } catch(Exception e) {
            //log.error("Failed to persist product : {} ", e);
        }
        return success;
    }
    
    public boolean deleteProduct(Product product) {
        boolean success = false;
        try {
            entityManager.remove(product);
            success = true;
        } catch(Exception e) {
            //log.error("Failed to delete product record : {}", product);
        }
        return success;
    } 
}
