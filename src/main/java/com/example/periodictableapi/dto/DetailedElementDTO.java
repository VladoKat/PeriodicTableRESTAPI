package com.example.periodictableapi.dto;

import com.example.periodictableapi.model.Element;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DetailedElementDTO {
    private int atomicNumber;
    private String alternativeName;
    private String name;
    private String atomicSymbol;
    private List<DiscovererDTO> discoverers;
    private String discoveryYear;
    private int group;
    private int period;

    public static DetailedElementDTO from(Element element) {
        return new DetailedElementDTO(element.getAtomicNumber(), element.getAlternativeName(),
                element.getName(), element.getAtomicSymbol(),
                element.getDiscoverers().stream().map(discoverer -> DiscovererDTO.from(discoverer)).collect(Collectors.toList()),
                element.getDiscoveryYear(), element.getGroup(), element.getPeriod());
    }
}
