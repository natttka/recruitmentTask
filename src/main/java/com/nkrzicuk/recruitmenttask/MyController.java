package com.nkrzicuk.recruitmenttask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

@RestController
public class MyController {

    private IMyService service;

    @PostMapping(path = "/add")
    public ResponseEntity<?> addName(@RequestBody @Valid MyDomainObjectDTO myDomainObjectDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error: bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(new AbstractMap.SimpleEntry<>("errors", errors), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.addName(myDomainObjectDTO), HttpStatus.OK);
        }
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> getAllNames() {
        List<MyDomainObject> allObjects = service.getAllNames();
        if (allObjects.isEmpty()) {
            return new ResponseEntity<>(new AbstractMap.SimpleEntry<>("message", "List is empty."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(allObjects, HttpStatus.OK);
        }
    }


    @Autowired
    public MyController(IMyService service) {
        this.service = service;
    }
}
