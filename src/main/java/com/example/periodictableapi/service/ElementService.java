package com.example.periodictableapi.service;

import com.example.periodictableapi.dto.DetailedElementDTO;
import com.example.periodictableapi.dto.RestrictedElementDTO;
import com.example.periodictableapi.form.ElementForm;

import java.util.List;


public interface ElementService {
    DetailedElementDTO getByAtomicNumber(int atomicNumber);
    List<DetailedElementDTO> getAllByGroup(int group);
    List<DetailedElementDTO> getAllByPeriod(int period);
    List<RestrictedElementDTO> getAll();
    void saveElements(List<ElementForm> elements);
}
