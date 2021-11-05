package com.example.periodictableapi.controller;

import com.example.periodictableapi.dto.RestrictedElementDTO;
import com.example.periodictableapi.form.ElementForm;
import com.example.periodictableapi.model.Element;
import com.example.periodictableapi.repository.ElementRepository;
import com.example.periodictableapi.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("element")
public class ElementController {

    @Autowired
    ElementService elementService;

    @PostMapping("/multiple")
    private ResponseEntity<String> postElements(@RequestBody List<ElementForm> elements)
    {
        elementService.saveElements(elements);
        return new ResponseEntity<>("Saved", HttpStatus.OK);
    }

    @GetMapping()
    private List<RestrictedElementDTO> getAllStudent()
    {
        return elementService.getAll();
    }
}
