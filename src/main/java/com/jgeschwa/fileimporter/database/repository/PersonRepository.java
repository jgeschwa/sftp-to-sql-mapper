package com.jgeschwa.fileimporter.database.repository;

import com.jgeschwa.fileimporter.model.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends BaseRepository<Person, UUID> {
}
