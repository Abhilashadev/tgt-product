package com.target.retail.tgtproduct.repository;

import com.target.retail.tgtproduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author abhilasha
 * @since 21/11/19
 */
public interface ProductRepository extends JpaRepository<Product,Object> {

    Product findById(String id);

}
