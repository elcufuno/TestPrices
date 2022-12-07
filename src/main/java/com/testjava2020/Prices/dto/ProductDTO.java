package com.testjava2020.Prices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;


@Data
public class ProductDTO implements Serializable {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;
}
