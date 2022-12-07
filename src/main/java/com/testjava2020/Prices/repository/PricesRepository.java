package com.testjava2020.Prices.repository;

import com.testjava2020.Prices.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface PricesRepository extends JpaRepository<Price,Long> {

   @Query("SELECT p FROM Price p " +
            "WHERE p.brand.id = :brand_id and p.product.id = :product_id and :date_application " +
            "BETWEEN p.start_date  and p.end_date " +
            "and p.priority = ( SELECT MAX(p.priority) FROM p )")
    Price findPriceByBrandIdAndProductId (@Param("date_application") LocalDateTime date_application, @Param("product_id") Long product_id,@Param("brand_id") Long brand_id);

}
