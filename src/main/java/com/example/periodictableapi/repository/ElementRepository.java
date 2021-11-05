package com.example.periodictableapi.repository;


import com.example.periodictableapi.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementRepository extends JpaRepository<Element, Integer> {

    Element getElementByAtomicNumber(Integer atomicNumber);
    List<Element> getAllByGroup(Integer atomicNumber);
    List<Element> getAllByPeriod(int period);
}
