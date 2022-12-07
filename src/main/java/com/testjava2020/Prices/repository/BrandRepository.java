package com.testjava2020.Prices.repository;

import com.testjava2020.Prices.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {
}
