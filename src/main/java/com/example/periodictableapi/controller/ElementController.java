package com.example.periodictableapi.controller;

import com.example.periodictableapi.dto.DetailedElementDTO;
import com.example.periodictableapi.dto.RestrictedElementDTO;
import com.example.periodictableapi.form.ElementForm;
import com.example.periodictableapi.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    private List<RestrictedElementDTO> getAllElements()
    {
        return elementService.getAll();
    }

    @GetMapping("/atomic_number/{atomicNumber}")
    private ResponseEntity<DetailedElementDTO> getElementByAtomicNumber(@PathVariable("atomicNumber") int atomicNumber)
    {
        return new ResponseEntity<>(elementService.getByAtomicNumber(atomicNumber), HttpStatus.OK);
    }

    @GetMapping("/group/{group}")
    private List<DetailedElementDTO> getElementByGroup(@PathVariable("group") int group)
    {
        return elementService.getAllByGroup(group);
    }

    @GetMapping("/period/{period}")
    private List<DetailedElementDTO> getElementByPeriod(@PathVariable("period") int period)
    {
        return elementService.getAllByPeriod(period);
    }
}
