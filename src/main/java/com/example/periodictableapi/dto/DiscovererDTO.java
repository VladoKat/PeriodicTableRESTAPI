package com.example.periodictableapi.dto;

import com.example.periodictableapi.model.Discoverer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DiscovererDTO {
    private String name;

    public static DiscovererDTO from(Discoverer discoverer) {
        return new DiscovererDTO(discoverer.getName());
    }
}
