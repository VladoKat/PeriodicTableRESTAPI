package com.example.periodictableapi.service;

import com.example.periodictableapi.dto.DetailedElementDTO;
import com.example.periodictableapi.dto.RestrictedElementDTO;
import com.example.periodictableapi.form.ElementForm;
import com.example.periodictableapi.repository.DiscovererRepository;
import com.example.periodictableapi.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElementServiceImpl implements ElementService{

    ElementRepository elementRepository;
    DiscovererRepository discovererRepository;

    @Autowired
    ElementServiceImpl(ElementRepository elementRepository, DiscovererRepository discovererRepository) {
        this.elementRepository = elementRepository;
        this.discovererRepository = discovererRepository;
    }

    @Override
    public DetailedElementDTO getByAtomicNumber(int atomicNumber) {
        return DetailedElementDTO.from(elementRepository.getElementByAtomicNumber(atomicNumber));
    }

    @Override
    public DetailedElementDTO getByGroup(int group) {
        return DetailedElementDTO.from(elementRepository.getElementByGroup(group));
    }

    @Override
    public List<RestrictedElementDTO> getAll() {
        return elementRepository.findAll().stream().map(RestrictedElementDTO::from).collect(Collectors.toList());
    }

    @Override
    public void saveElements(List<ElementForm> elements) {
        elementRepository.saveAll(elements.stream().map(ElementForm::convertToElement).collect(Collectors.toList()));
    }
}
