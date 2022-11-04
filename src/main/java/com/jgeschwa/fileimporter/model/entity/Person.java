package com.jgeschwa.fileimporter.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String lastName;
    private String email;
    private String address;
    private String title;
    @JsonProperty(value = "date_of_birth")
    private String dateOfBirth;
    @JsonProperty(value = "phone_number")
    private String phoneNumber;
}
