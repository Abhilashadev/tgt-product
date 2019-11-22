package com.target.retail.tgtproduct.productdetailproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author abhilasha
 * @since 21/11/19
 */
@FeignClient(name = "tgt-product-details")
public interface ProdutDetailProxy {

    @GetMapping(value = "/productDetails/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getProductData(@PathVariable(value = "id") String id);
}
