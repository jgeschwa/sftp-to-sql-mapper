package com.jgeschwa.fileimporter.service;

import com.jgeschwa.fileimporter.database.repository.PersonRepository;
import com.jgeschwa.fileimporter.model.Person;
import com.jgeschwa.fileimporter.utils.JsonConverter;
import com.jgeschwa.fileimporter.utils.XmlConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void doImport(String content) {
        List<Person> personList;
        if (content.charAt(0) == '<') {
            personList = XmlConverter.convertList(content, List.class, Person.class);
            System.out.println("Xml converting done");
        } else {
            personList = JsonConverter.convertList(content, List.class, Person.class);
            System.out.println("Json converting done");
        }
        personRepository.saveAll(personList);
    }

}
