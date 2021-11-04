package com.example.periodictableapi.controller;

import com.example.periodictableapi.model.Element;
import com.example.periodictableapi.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("element")
public class ElementController {

    @Autowired
    ElementRepository elementRepository;

    @GetMapping("/hiPost")
    private ResponseEntity<String> postElement()
    {
        return new ResponseEntity<>("Hi", HttpStatus.OK);
    }

    @GetMapping("/hiGETALL")
    private List<Element> getAllStudent()
    {
//        elementRepository.save(new Element(1, "altName", "name", "appnc"));
        return elementRepository.findAll();
    }
}
