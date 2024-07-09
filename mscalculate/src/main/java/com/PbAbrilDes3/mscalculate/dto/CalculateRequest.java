package com.PbAbrilDes3.mscalculate.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CalculateRequest {
    @NotNull(message = "CategoryId is mandatory")
    private Long categoryId;
    @NotNull(message = "Value is mandatory")
    private Integer value;
}
