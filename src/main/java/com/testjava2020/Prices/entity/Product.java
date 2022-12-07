package com.testjava2020.Prices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Data
@Entity
@Table(name="product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private static final long serialVersionUID = 8505139494494418865L;

    @Id
    private long id;

    @Column(name="name",nullable = false)
    private String name;
}
