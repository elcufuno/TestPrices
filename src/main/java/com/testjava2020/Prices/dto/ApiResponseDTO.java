package com.testjava2020.Prices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ApiResponseDTO")
public class ApiResponseDTO<T> {

    @Schema(example = "200")
    @JsonProperty(value = "code")
    protected int code;

    @Schema(example = "Message")
    @JsonProperty(value = "message")
    protected String message;

    @Schema(example = "Error message.")
    @JsonProperty(value = "error")
    protected List<String> error;

    @JsonProperty(value = "data")
    protected T data;

}
