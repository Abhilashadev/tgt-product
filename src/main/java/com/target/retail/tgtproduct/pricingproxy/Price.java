package com.target.retail.tgtproduct.pricingproxy;

import com.target.retail.tgtproduct.model.Product;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.money.MonetaryAmount;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author abhilasha
 * @since 21/11/19
 */
@Entity
public class Price extends AbstractAggregateRoot {

    @Id
    private String id;

    private String amount;

}
