package com.testjava2020.Prices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;


@Data
@Entity
@Table(name="brands")
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    private static final long serialVersionUID = 8505139494494418865L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name",nullable = false)
    private String name;
}
