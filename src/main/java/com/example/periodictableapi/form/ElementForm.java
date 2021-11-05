package com.example.periodictableapi.form;

import com.example.periodictableapi.model.Discoverer;
import com.example.periodictableapi.model.Element;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Getter
public class ElementForm {
    private static final String EMPTY_VALUE = "n/a";
    private static final String UNKNOWN_VALUE = "unknown";
    private static final String NONE_VALUE = "none";


    private int atomicNumber; //atomic_number
    private String alternativeName; // alternative_name -extract alternativeName
    private String alternativeNames; //alternative_names - extract alternativeName
    private String name; //name
    private String appearance; //appearance
    private String symbol; //symbol
    private int period; //period
    private String groupBlock; //group_block - extract group
    private String discovery; //discovery - extract discoverers and discoveryYear
    private String discoveryAndFirstIsolation; //discovery_and_first_isolation - extract discoverers and discoveryYear

    @JsonCreator
    public ElementForm(@JsonProperty("atomic_number") int atomicNumber, @JsonProperty("alternative_name") String alternativeName,
                       @JsonProperty("alternative_names") String alternativeNames, @JsonProperty("name") String name,
                       @JsonProperty("appearance") String appearance, @JsonProperty("symbol") String symbol,
                       @JsonProperty("period") int period, @JsonProperty("group_block") String groupBlock,
                       @JsonProperty("discovery") String discovery, @JsonProperty("discovery_and_first_isolation") String discoveryAndFirstIsolation) {
        this.atomicNumber = atomicNumber;
        this.alternativeName = alternativeName;
        this.alternativeNames = alternativeNames;
        this.name = name;
        this.appearance = appearance;
        this.symbol = symbol;
        this.period = period;
        this.groupBlock = groupBlock;
        this.discovery = discovery;
        this.discoveryAndFirstIsolation = discoveryAndFirstIsolation;
    }

    public Element convertToElement() {
        return new Element(0L, atomicNumber, extractAlternativeName(),
                name, appearance, symbol, period,
                extractGroup(), extractDiscoveryYear(), extractDiscoverers());
    }

    private boolean isEmptyString(String strToCheck) {
        return strToCheck == null || strToCheck.trim().isEmpty() || strToCheck == EMPTY_VALUE;
    }

    private List<Discoverer> extractDiscoverers() {
        List<Discoverer> discoverersResult = new ArrayList<>();
        discoverersResult.addAll(extractNamesFromDiscovery(discovery));
        discoverersResult.addAll(extractNamesFromDiscovery(discoveryAndFirstIsolation));
        return discoverersResult;
    }

    private Collection<? extends Discoverer> extractNamesFromDiscovery(String discovery) {
        List<Discoverer> discoverers = new ArrayList<>();
        if(!isEmptyString(discovery)){
           discoverers.addAll(Arrays.stream(discovery.split(",|and"))
                   .map(discovererName -> new Discoverer(0L, removeYearFrom(discovererName.trim()))).collect(Collectors.toList()));
        }
        return discoverers;
    }

    private String removeYearFrom(String discovery) {
        int indexOfParenthesis = discovery.indexOf('(');
        return discovery.substring(0, indexOfParenthesis > 0 ? indexOfParenthesis : discovery.length());
    }

    private String extractDiscoveryYear() {
        if(!isEmptyString(discovery)){
            return extractDiscoveryYearFrom(discovery);
        }
        if(!isEmptyString(discoveryAndFirstIsolation)){
            return extractDiscoveryYearFrom(discoveryAndFirstIsolation);
        }
        return UNKNOWN_VALUE;
    }

    private String extractDiscoveryYearFrom(String discoveryField){
        int indexOfLeftParenthesis = discoveryField.indexOf('(');
        int indexOfRightParenthesis = discoveryField.indexOf(')');
        if(indexOfLeftParenthesis == -1 || indexOfRightParenthesis == -1){
            return UNKNOWN_VALUE;
        }
        return discoveryField.substring(indexOfLeftParenthesis, indexOfRightParenthesis);
    }

    private int extractGroup() {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(groupBlock);
        return matcher.find() ? Integer.parseInt(matcher.group()) : 0;
    }

    private String extractAlternativeName() {
        if(!isEmptyString(alternativeName)){
            return alternativeName;
        }
        if(!isEmptyString(alternativeNames)) {
            return extractAlternativeNameFrom(alternativeNames);
        }
        return NONE_VALUE;
    }

    private String extractAlternativeNameFrom(String alternativeNames) {
        List<String> names = Arrays.asList(alternativeNames.split(","));
        return names.size() > 1 ? names.get(1) : alternativeNames;
    }
}
