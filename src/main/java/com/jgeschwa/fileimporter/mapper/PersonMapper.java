package com.jgeschwa.fileimporter.mapper;

import com.jgeschwa.fileimporter.model.dto.PersonDto;
import com.jgeschwa.fileimporter.model.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    // entity to Dto
    PersonDto mapToDto(Person person);
    List<PersonDto> mapToDto(List<Person> personList);

    // Dto to entity
    @Mapping(target = "id", ignore = true)
    Person mapToEntity(PersonDto personDto);
    List<Person> mapToEntity(List<PersonDto> personDtoList);
}
