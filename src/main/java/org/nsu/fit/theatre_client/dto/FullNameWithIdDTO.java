package org.nsu.fit.theatre_client.dto;

import lombok.Data;

@Data
public class FullNameWithIdDTO {
    Integer id;
    String firstName;
    String lastName;
    String patronymicName;
}
