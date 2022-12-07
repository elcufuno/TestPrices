package com.testjava2020.Prices.controller;

import com.testjava2020.Prices.dto.ApiResponseDTO;
import com.testjava2020.Prices.dto.PriceDTO;
import com.testjava2020.Prices.entity.Price;
import com.testjava2020.Prices.service.PriceService;
import com.testjava2020.Prices.util.MappingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PricesController {

    private final PriceService priceService;

    private final MappingService mappingService;

    public PricesController(PriceService priceService,MappingService mappingService){
        this.priceService=priceService;
        this.mappingService=mappingService;
    }

    @GetMapping("{id}")
    public ResponseEntity <ApiResponseDTO<PriceDTO>> SearchPrice(@PathVariable("id") Long id) {

        Price price = priceService.SearchPrice2(id);

        PriceDTO priceDTO = mappingService.map(price,PriceDTO.class);

        return ResponseEntity.ok(ApiResponseDTO.<PriceDTO>builder()
                .code(HttpStatus.OK.value())
                .message("Price result:")
                .data(priceDTO)
                .build());
    }

    @GetMapping("/{date_application}/{product_id}/{brand_id}")
    public ResponseEntity <ApiResponseDTO<PriceDTO>> getPrice(@PathVariable(value="date_application")
                                                                  @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime date_application,
                                                              @PathVariable(value="product_id") Long product_id,
                                                              @PathVariable(value="brand_id") Long brand_id) {

        Price price = priceService.getPrice(date_application,product_id,brand_id);

        PriceDTO priceDTO = mappingService.map(price,PriceDTO.class);

        return ResponseEntity.ok(ApiResponseDTO.<PriceDTO>builder()
                .code(HttpStatus.OK.value())
                .message("Price retrieved successfully")
                .data(priceDTO)
                .build());
    }

}
