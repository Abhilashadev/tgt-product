package com.target.retail.tgtproduct.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.target.retail.tgtproduct.exception.ProductErrorCode;
import com.target.retail.tgtproduct.exception.ProductException;
import com.target.retail.tgtproduct.exception.ProductResourceConstant;
import com.target.retail.tgtproduct.model.Product;
import com.target.retail.tgtproduct.repository.ProductRepository;
import com.target.retail.tgtproduct.rest.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author abhilasha
 * @since 21/11/19
 */

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(ProductController.ProductData productData) {
        return null;
    }

    @Override
    public Product updateProductDetails(ProductController.ProductData productData) {
        return null;
    }

    @Override
    public Product getProductById(String id) {
        if(id == null || id.isEmpty())
            throw new ProductException(ProductResourceConstant.PRODUCT_ID_CANNOT_BE_EMPTY, ProductErrorCode.PRODUCT_ID_CANNOT_BE_EMPTY);
        Product product = productRepository.findById(id);
        if(product == null)
            throw new ProductException(ProductResourceConstant.PRODUCT_NOT_FOUND, ProductErrorCode.PRODUCT_NOT_FOUND);
        // TODO Get the price and product name details.

        return product;
    }

}
