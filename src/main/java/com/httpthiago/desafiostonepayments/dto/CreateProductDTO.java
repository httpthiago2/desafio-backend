package com.httpthiago.desafiostonepayments.dto;

import com.httpthiago.desafiostonepayments.model.Product;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter @Setter @NoArgsConstructor
public class CreateProductDTO {
    private String title;
    private BigDecimal price;
    private String zipcode;
    private String seller;
    private String thumbnailHd;
    private String date;

    public Product converToEntity() {
        Product entity = new Product();
        entity.setTitle(this.getTitle());
        entity.setPrice(this.getPrice());
        entity.setZipcode(this.getZipcode());
        entity.setSeller(this.getSeller());
        entity.setThumbnailHd(this.getThumbnailHd());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        entity.setDate(LocalDate.parse(date, formatter));
        return entity;
    }

}
