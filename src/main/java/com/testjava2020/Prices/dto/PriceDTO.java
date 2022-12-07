package com.testjava2020.Prices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testjava2020.Prices.entity.Brand;
import com.testjava2020.Prices.entity.Product;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PriceDTO implements Serializable {

    @JsonProperty("id")
    private long id;

    @JsonProperty("brand")
    private Brand brand;

    @JsonProperty("product")
    private Product product;

    @JsonProperty("start_date")
    private LocalDateTime start_date;

    @JsonProperty("end_date")
    private LocalDateTime end_date;

    @JsonProperty("price_list")
    private String price_list;

    @JsonProperty("priority")
    private String priority;

    @JsonProperty("price")
    private String price;

    @JsonProperty("curr")
    private String curr;
}
