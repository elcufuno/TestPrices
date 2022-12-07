package com.testjava2020.Prices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data

public class GetPriceDTO implements Serializable {

    @NotNull
    @Schema(example = "2021-01-10")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("date_application")
    private LocalDateTime date_application;

    @NotNull(message = "Field flow_id is null and it is required")
    @Min(1)
    @Schema(example = "1")
    @JsonProperty("product_id")
    private Long product_id;

    @NotNull(message = "Field flow_id is null and it is required")
    @Min(1)
    @Schema(example = "1")
    @JsonProperty("brand_id")
    private Long brand_id;
}
