package com.PbAbrilDes3.mscalculate.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CalculateResponse {
    private int total;

    public CalculateResponse(int total) {
        this.total = total;
    }
}
