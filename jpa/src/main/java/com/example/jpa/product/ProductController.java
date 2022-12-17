package com.example.jpa.product;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ApiResponse<Product> getProducts(){
        List<Product> products = productService.findAllProducts();
        return new ApiResponse<>(products.size(),products);
    }

    @GetMapping("/{field}/")
    public ApiResponse<Product> getProductsWithSort(@PathVariable String field){
        List<Product> products = productService.findProductsWithSorting(field);
        return new ApiResponse<>(products.size(), products);
    }

    @GetMapping("/pagination/{offset}/{pagesize}/")
    public Page<Product> getProductsWithPagination(@PathVariable int offset, @PathVariable int pagesize){
        return productService.findProductsWithPagination(offset, pagesize);
//        return new ApiResponse<>(products.getSize(), products.toList());
    }
}
