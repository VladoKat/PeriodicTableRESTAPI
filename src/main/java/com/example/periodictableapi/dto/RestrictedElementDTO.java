package com.example.periodictableapi.dto;

import com.example.periodictableapi.model.Element;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RestrictedElementDTO {
    private int atomicNumber;
    private String name;

    public static RestrictedElementDTO from(Element element) {
        return new RestrictedElementDTO(element.getAtomicNumber(), element.getName());
    }
}
