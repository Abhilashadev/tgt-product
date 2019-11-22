package com.target.retail.tgtproduct.rest;

import com.target.retail.tgtproduct.model.Product;
import com.target.retail.tgtproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;


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
        LinkedHashMap product = productService.getProductById(id);
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



    public static class ProductData{
        private String id;
        private String name;
        private Price price;


        ProductData(){

        }
        public ProductData(String id,String name,Price price){
            this.id = id;
            this.name=name;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Price getPrice() {
            return price;
        }

        public void setPrice(Price price) {
            this.price = price;
        }
    }

    public static class Price{
        String value;
        String currency;

        Price(){}
        Price(String value,String currency){
            this.value = value;
            this.currency = currency;
        }
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
