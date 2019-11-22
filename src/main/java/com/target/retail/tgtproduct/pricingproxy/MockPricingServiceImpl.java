package com.target.retail.tgtproduct.pricingproxy;

import com.target.retail.tgtproduct.rest.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author abhilasha
 * @since 21/11/19
 */

@Service
public class MockPricingServiceImpl implements PricingService {


    @Autowired
    PriceRepository priceRepository;


    @Override
    public Price getPriceForProduct(String productId) {
        Price price = priceRepository.findByProductId(productId);
        if(price != null)
            return price;
        return new Price("5,00","EUR",productId);
    }


    public void updatePrice(String productId, ProductController.Price price) {
        Price price1 = priceRepository.findByProductId(productId);
        if(price1 == null){
            price1 = new Price();
            price1.setProductId(productId);
        }
        price1.setCurrency(price.getCurrency());
        price1.setValue(price.getValue());
        priceRepository.save(price1);
    }
}
