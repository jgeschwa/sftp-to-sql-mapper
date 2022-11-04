package com.jgeschwa.fileimporter.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String title;
    private String dateOfBirth;
    private String phoneNumber;
}
