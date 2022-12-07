package com.testjava2020.Prices.service.impl;

import com.testjava2020.Prices.entity.Brand;
import com.testjava2020.Prices.entity.Price;
import com.testjava2020.Prices.entity.Product;
import com.testjava2020.Prices.repository.BrandRepository;
import com.testjava2020.Prices.repository.ProductRepository;
import com.testjava2020.Prices.service.PriceService;
import com.testjava2020.Prices.repository.PricesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    @Autowired
    private final PricesRepository pricesRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final BrandRepository brandRepository;

    @Override
    public Price getPrice(LocalDateTime date_application, Long product_id, Long brand_id) {

        Brand brand = findBrandById(brand_id);
        Product product = findProductById(product_id);

        Price price = pricesRepository.findPriceByBrandIdAndProductId(date_application,product_id,brand_id);

        if (price == null){
            throw new EntityNotFoundException("No data found with the params send");
        }

        return price;
    }

    private Brand findBrandById(Long id) {
        return brandRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Brand with id %1$s not found", id)));
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Product with id %1$s not found", id)));
    }

    @Override
    public Price SearchPrice2(Long id) {
        return pricesRepository.findById(id).orElseThrow(() -> {throw new RuntimeException();});
    }

}
