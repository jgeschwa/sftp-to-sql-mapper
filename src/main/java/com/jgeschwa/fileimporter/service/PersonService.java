package com.jgeschwa.fileimporter.service;

import com.jgeschwa.fileimporter.database.repository.PersonRepository;
import com.jgeschwa.fileimporter.mapper.PersonMapper;
import com.jgeschwa.fileimporter.model.dto.PersonDto;
import com.jgeschwa.fileimporter.model.entity.Person;
import com.jgeschwa.fileimporter.utils.JsonConverter;
import com.jgeschwa.fileimporter.utils.XmlConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;

    public PersonService(PersonRepository personRepository, PersonMapper mapper) {
        this.repository = personRepository;
        this.mapper = mapper;
    }

    public void doImport(String content) {
        repository.deleteAll();
        List<Person> personList;
        if (content.charAt(0) == '<') {
            personList = XmlConverter.convertList(content, List.class, Person.class);
            log.info("Xml converting done");
        } else {
            personList = JsonConverter.convertList(content, List.class, Person.class);
            log.info("Json converting done");
        }
        repository.saveAll(personList);
    }

    public PersonDto getById(UUID uuid) {
        return mapper.mapToDto(repository.findById(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Person with id "+ uuid + " was not found")
        ));
    }

}
