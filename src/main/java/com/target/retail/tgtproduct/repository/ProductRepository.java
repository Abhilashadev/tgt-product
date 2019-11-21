package com.target.retail.tgtproduct.repository;

import com.target.retail.tgtproduct.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @author abhilasha
 * @since 21/11/19
 */
public interface ProductRepository extends CrudRepository<Long,String> {

    Product findById(String id);
}
