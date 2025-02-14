package com.httpthiago.desafiostonepayments.model;

import com.httpthiago.desafiostonepayments.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "products")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "zip_code")
    private String zipcode;

    @Column(name = "seller")
    private String seller;

    @Column(name = "thumbnail_hd")
    private String thumbnailHd;

    @Column(name = "registry_date")
    private LocalDate date;

    public ProductDTO convertToDto() {
        ProductDTO dto = new ProductDTO();
        dto.setTitle(this.getTitle());
        dto.setPrice(this.getPrice());
        dto.setZipcode(this.getZipcode());
        dto.setSeller(this.getSeller());
        dto.setThumbnailHd(this.getThumbnailHd());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dto.setDate(this.date.format(formatter));
        return dto;
    }
}
