package com.target.retail.tgtproduct.productdetailproxy;

import com.target.retail.tgtproduct.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author abhilasha
 * @since 21/11/19
 */
@FeignClient(name = "tgt-product")
public interface ProdutDetailProxy {

    @RequestMapping(value = "/employee/find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity getProductData(@PathVariable(value = "id") String id);
}
