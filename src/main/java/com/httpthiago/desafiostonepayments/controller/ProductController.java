package com.httpthiago.desafiostonepayments.controller;

import com.httpthiago.desafiostonepayments.dto.CreateProductDTO;
import com.httpthiago.desafiostonepayments.model.Product;
import com.httpthiago.desafiostonepayments.repository.ProductRepository;
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
    public List<CreateProductDTO> findAll() {
        return productService.findAll();
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateProductDTO create(@RequestBody CreateProductDTO product) {
        return productService.createProduct(product);
    }
}
