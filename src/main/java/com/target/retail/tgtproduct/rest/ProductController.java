package com.target.retail.tgtproduct.rest;

import com.target.retail.tgtproduct.model.Product;
import com.target.retail.tgtproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.money.MonetaryAmount;

/**
 * @author abhilasha
 * @since 21/11/19
 */

@RepositoryRestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/products/{id}")
    ResponseEntity<Object> getProduct(@PathVariable(value = "id")String id){
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/products/{id}")
    ResponseEntity<Object> createProduct(@RequestBody ProductData productData){
        Product product = productService.createProduct(productData);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(value = "/products/{id}")
    ResponseEntity<Object> updateProduct(@RequestBody ProductData productData){
        Product product = productService.updateProductDetails(productData);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }



    public class ProductData{
        private String id;
        private String name;
        private Price price;
    }

    public class Price{
        String amount;
    }
}
