package com.httpthiago.desafiostonepayments.service;

import com.httpthiago.desafiostonepayments.dto.ProductDTO;
import com.httpthiago.desafiostonepayments.model.Product;
import com.httpthiago.desafiostonepayments.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductService {
    private Logger logger = Logger.getLogger(ProductService.class.getName());

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        logger.info("###Finding all products...");
        List<ProductDTO> list = new ArrayList<>();
        productRepository.findAll().forEach(product -> list.add(product.convertToDto()));
        return list;
    }

    public ProductDTO createProduct(ProductDTO product) {
        logger.info("###Creating a product");
        Product entityProduct = productRepository.save(product.converToEntity());
        return entityProduct.convertToDto();
    }
}
