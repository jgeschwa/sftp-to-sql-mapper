package com.jgeschwa.fileimporter.service;

import com.jgeschwa.fileimporter.database.repository.PersonRepository;
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

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void doImport(String content) {
        personRepository.deleteAll();
        List<Person> personList;
        if (content.charAt(0) == '<') {
            personList = XmlConverter.convertList(content, List.class, Person.class);
            log.info("Xml converting done");
        } else {
            personList = JsonConverter.convertList(content, List.class, Person.class);
            log.info("Json converting done");
        }
        personRepository.saveAll(personList);
    }

    public Person getById(UUID uuid) {
        return personRepository.findById(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Person with id "+ uuid + " not found")
        );
    }

}
