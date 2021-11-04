package com.example.periodictableapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RestrictedElementDTO {
    private int atomicNumber;
    private String name;
}
