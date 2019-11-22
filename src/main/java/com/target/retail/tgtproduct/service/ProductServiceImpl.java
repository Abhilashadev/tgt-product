package com.target.retail.tgtproduct.service;
import com.target.retail.tgtproduct.exception.ProductErrorCode;
import com.target.retail.tgtproduct.exception.ProductException;
import com.target.retail.tgtproduct.exception.ProductResourceConstant;
import com.target.retail.tgtproduct.model.Product;
import com.target.retail.tgtproduct.pricingproxy.MockPricingServiceImpl;
import com.target.retail.tgtproduct.pricingproxy.Price;
import com.target.retail.tgtproduct.productdetailproxy.ProdutDetailProxy;
import com.target.retail.tgtproduct.repository.ProductRepository;
import com.target.retail.tgtproduct.rest.ProductController;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

/**
 * @author abhilasha
 * @since 21/11/19
 */

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProdutDetailProxy produtDetailProxy;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MockPricingServiceImpl mockPricingService;

    @Override
    public Product createProduct(ProductController.ProductData productData) {
        Product product = new Product(productData.getId());
        productRepository.save(product);
        mockPricingService.updatePrice(product.getId(),productData.getPrice());
        return null;
    }

    @Override
    public Product updateProductDetails(ProductController.ProductData productData) {
        Product product = productRepository.findById(productData.getId());
        if(product == null)
            throw new ProductException(ProductResourceConstant.PRODUCT_NOT_FOUND, ProductErrorCode.PRODUCT_NOT_FOUND);
        mockPricingService.updatePrice(product.getId(),productData.getPrice());
        return product;
    }

    @Override
    public LinkedHashMap<String, Object> getProductById(String id) {
        if(id == null || id.isEmpty())
            throw new ProductException(ProductResourceConstant.PRODUCT_ID_CANNOT_BE_EMPTY, ProductErrorCode.PRODUCT_ID_CANNOT_BE_EMPTY);
        Product product = productRepository.findById(id);
        LinkedHashMap<String,Object> pdrDetails = new LinkedHashMap<>(0);
        if(product == null)
            throw new ProductException(ProductResourceConstant.PRODUCT_NOT_FOUND, ProductErrorCode.PRODUCT_NOT_FOUND);
        try{
            // Get the product name from product detail microservice
            ResponseEntity productDetail = produtDetailProxy.getProductData(id);
            if(productDetail != null && productDetail.getBody() != null){
                pdrDetails =(LinkedHashMap<String, Object>) productDetail.getBody();
            }
        }catch (FeignException e){
            throw new ProductException(ProductResourceConstant.PRODUCT_NOT_FOUND, ProductErrorCode.PRODUCT_NOT_FOUND);
        }

        //
        if(pdrDetails != null){
            Price price =  mockPricingService.getPriceForProduct(id);
            pdrDetails.put("price",price);
        }
        return pdrDetails;
    }


}
