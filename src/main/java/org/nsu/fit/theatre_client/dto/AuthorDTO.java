package org.nsu.fit.theatre_client.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class AuthorDTO {
    Integer id;
    String firstName;
    String lastName;
    String patronymicName;
    String country;
    Date birthDate;
}
