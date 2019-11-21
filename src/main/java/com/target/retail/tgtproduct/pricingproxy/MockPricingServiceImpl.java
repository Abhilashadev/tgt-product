package com.target.retail.tgtproduct.pricingproxy;

import org.springframework.stereotype.Service;

/**
 * @author abhilasha
 * @since 21/11/19
 */

@Service
public class MockPricingServiceImpl implements PricingService {



    @Override
    public Price getPriceForProduct(String productId) {
        return null;
    }


}
