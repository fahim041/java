package com.example.jpa.product;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @PostConstruct
//    public void initDB(){
//        List<Product> products = IntStream.rangeClosed(1, 200).mapToObj(i -> new Product("product - "+ i, (double) new Random().nextInt(500), new Random().nextInt(100))).collect(Collectors.toList());
//        productRepository.saveAll(products);
//    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> findProductsWithSorting(String field){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Product> findProductsWithPagination(int offset, int pageSize){
        return productRepository.findAll(PageRequest.of(offset, pageSize));
    }
}
