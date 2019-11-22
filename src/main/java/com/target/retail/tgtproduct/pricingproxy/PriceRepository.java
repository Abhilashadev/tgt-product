package com.target.retail.tgtproduct.pricingproxy;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author abhilasha
 * @since 22/11/19
 */
public interface PriceRepository extends JpaRepository<Price,Object> {
    Price findByProductId(String productId);
}
