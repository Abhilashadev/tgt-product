package com.target.retail.tgtproduct.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author abhilasha
 * @since 21/11/19
 */

@Entity
public class Product {

    @Id
    private String id;

    private transient String name;
    private transient String brand;

    public Product(){

    }
    public Product(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
