package com.target.retail.tgtproduct.service;

import com.target.retail.tgtproduct.model.Product;
import com.target.retail.tgtproduct.rest.ProductController;

import java.util.LinkedHashMap;

/**
 * @author abhilasha
 * @since 21/11/19
 */

public interface ProductService {

    /**
     *
     * Calls (tgt-product-details) and creates a product.
     * Adds the product(id) in the tgt-product
     * Adds the price details of the product in tgt-pricing(Mock)
     *
     * @Function Creates the product
     * @param productData
     * @return product
     */
    Product createProduct(ProductController.ProductData productData);

    /**
     * @Function Updates the existing product
     * @param productData
     * @return updated product
     */
    Product updateProductDetails(ProductController.ProductData productData);

    /**
     * @Function Fetches the product by Id
     * @param id
     * @return product
     */
    LinkedHashMap<String, Object> getProductById(String id);
}
