package com.target.retail.tgtproduct.model;

import org.springframework.data.domain.AbstractAggregateRoot;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author abhilasha
 * @since 21/11/19
 */

@Entity
public class Product {

    @Id
    private String id;

    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;

}
