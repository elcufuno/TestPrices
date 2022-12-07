package com.testjava2020.Prices.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="price")
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    private static final long serialVersionUID = 8505139494494418865L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "start_date", columnDefinition = "TIMESTAMP", updatable = false, nullable = false)
    private LocalDateTime start_date;

    @Column(name = "end_date", columnDefinition = "TIMESTAMP", updatable = false, nullable = false)
    private LocalDateTime end_date;

    @Column(name="price_list",nullable = false)
    private String price_list;

    @Column(name="priority",nullable = false)
    private String priority;

    @Column(name="price",nullable = false)
    private String price;

    @Column(name="curr",nullable = false)
    private String curr;
}
