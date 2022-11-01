package com.jgeschwa.fileimporter.api.controller;

import com.jgeschwa.fileimporter.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

}
