package com.target.retail.tgtproduct.pricingproxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

/**
 * @author abhilasha
 * @since 21/11/19
 */
@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private String value;
    private String currency;

    @Column(unique = true)
    @JsonIgnore
    private String productId;

    Price(){

    }

    public Price(String value,String currency,String productId){
        this.value=value;
        this.currency = currency;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
