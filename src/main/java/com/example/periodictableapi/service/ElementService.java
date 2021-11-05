package com.example.periodictableapi.service;

import com.example.periodictableapi.dto.DetailedElementDTO;
import com.example.periodictableapi.dto.RestrictedElementDTO;
import com.example.periodictableapi.form.ElementForm;

import java.util.List;


public interface ElementService {
    DetailedElementDTO getByAtomicNumber(int atomicNumber);
    DetailedElementDTO getByGroup(int group);
    List<RestrictedElementDTO> getAll();
    void saveElements(List<ElementForm> elements);
}
