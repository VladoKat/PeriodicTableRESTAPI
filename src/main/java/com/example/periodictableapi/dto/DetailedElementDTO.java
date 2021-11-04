package com.example.periodictableapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DetailedElementDTO {
    private int atomicNumber;
    private String alternativeName;
    private String name;
    private String atomic_symbol;
    private List<DiscovererDTO> discoverers;
    private String discoveryYear;
    private int group;
    private int period;
}
