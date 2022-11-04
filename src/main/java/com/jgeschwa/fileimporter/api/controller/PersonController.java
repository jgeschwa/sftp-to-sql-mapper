package com.jgeschwa.fileimporter.api.controller;

import com.jgeschwa.fileimporter.model.dto.PersonDto;
import com.jgeschwa.fileimporter.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping("/{uuid}")
    public ResponseEntity<PersonDto> getById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(
                service.getById(uuid)
        );
    }
}
