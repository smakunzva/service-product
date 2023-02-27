package com.cakeboss.service.product.services;

import com.cakeboss.service.product.data.ProductDto;
import com.cakeboss.service.product.object.Product;
import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;

/**
 *
 * @author stevemak
 */
public class ProductService {
    @Inject
    ProductDto productDto;
    @Inject
    ModelMapper modelMaper;
    
    public Product findProduct(Long id) {
        com.cakeboss.service.product.data.Product product = productDto.findProduct(id);
        return modelMaper.map(product, Product.class);
    }
    
    public boolean createUpdateProduct(Product product) {
        return productDto.createUpadteProduct(modelMaper.map(product, com.cakeboss.service.product.data.Product.class));
    }
    
    public boolean deleteProduct(Long id) {
        return productDto.deleteProduct(productDto.findProduct(id));
    }
    
}
