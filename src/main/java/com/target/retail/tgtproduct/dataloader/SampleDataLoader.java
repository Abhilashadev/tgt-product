package com.target.retail.tgtproduct.dataloader;

import com.target.retail.tgtproduct.model.Product;
import com.target.retail.tgtproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * @author abhilasha
 * @since 21/11/19
 */
@Component
public class SampleDataLoader implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSampleProductData();

    }


    /**
     *  Listens to product event and creates the product details based on the event
     *  For test
     *
     *
     */
    private void loadSampleProductData() {


        Stream<String> productIds = Stream.of("15117729", "16483589", "16696652", "16752456", "15643793");
        productIds.forEach(this::createProduct);
    }

    private void createProduct(String id) {
        Product pdt = new Product(id);
        productRepository.save(pdt);
    }
}
