package com.testjava2020.Prices.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testjava2020.Prices.entity.Brand;
import com.testjava2020.Prices.entity.Price;
import com.testjava2020.Prices.entity.Product;
import com.testjava2020.Prices.service.PriceService;
import com.testjava2020.Prices.util.MappingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;


import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = PricesController.class)
public class PriceControllerTest {

    @MockBean
    private PriceService priceService;

    @MockBean
    private MappingService mappingService;

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void test_getPriceTest1 () throws Exception {

        when(priceService.getPrice(any(LocalDateTime.class),anyLong(),anyLong())).thenReturn(getPriceObjet());

        this.mockMvc
                .perform(get("/prices/2020-06-14T10:00:00/35455/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Price retrieved successfully"))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.error").isEmpty());

    }

    @Test
    void test_getPriceTest2 () throws Exception {

        when(priceService.getPrice(any(LocalDateTime.class),anyLong(),anyLong())).thenReturn(getPriceObjet());

        this.mockMvc
                .perform(get("/prices/2020-06-14T16:00:00/35455/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Price retrieved successfully"))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.error").isEmpty());

    }

    @Test
    void test_getPriceTest3 () throws Exception {

        when(priceService.getPrice(any(LocalDateTime.class),anyLong(),anyLong())).thenReturn(getPriceObjet());

        this.mockMvc
                .perform(get("/prices/2020-06-14T21:00:00/35455/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Price retrieved successfully"))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.error").isEmpty());

    }

    @Test
    void test_getPriceTest4 () throws Exception {

        when(priceService.getPrice(any(LocalDateTime.class),anyLong(),anyLong())).thenReturn(getPriceObjet());

        this.mockMvc
                .perform(get("/prices/2020-06-15T10:00:00/35455/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Price retrieved successfully"))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.error").isEmpty());

    }

    @Test
    void test_getPriceTest5 () throws Exception {

        when(priceService.getPrice(any(LocalDateTime.class),anyLong(),anyLong())).thenReturn(getPriceObjet());

        this.mockMvc
                .perform(get("/prices/2020-06-16T21:00:00/35455/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Price retrieved successfully"))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.error").isEmpty());

    }

    private Price getPriceObjet(){
        Brand brand = new Brand(1,"ZARA");

        Product product = new Product(35455,"test");

        Price price = new Price(1,brand,product, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),"1","0","35.50","EUR");

        return price;
    }
}
