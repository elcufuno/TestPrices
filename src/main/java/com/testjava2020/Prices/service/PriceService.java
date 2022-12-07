package com.testjava2020.Prices.service;

import com.testjava2020.Prices.entity.Price;

import java.time.LocalDateTime;


public interface PriceService {
    Price getPrice(LocalDateTime date_application, Long product_id, Long brand_id);

    Price SearchPrice2(Long id);
}
