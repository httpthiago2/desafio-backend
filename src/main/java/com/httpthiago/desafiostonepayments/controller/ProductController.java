package com.httpthiago.desafiostonepayments.controller;

import com.httpthiago.desafiostonepayments.dto.ProductDTO;
import com.httpthiago.desafiostonepayments.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/startore/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ProductDTO create(@RequestBody ProductDTO product) {
        return productService.createProduct(product);
    }
}
