package org.nsu.fit.theatre_client.dto;

import lombok.Data;

@Data
public class ActorDTO {
    Integer id;
    EmployeeDTO employeeDTO;
    Boolean honored_artist;
    Boolean national_artist;
    Boolean student;

    String voice;
    String height;
    String age;
    String gender;
}
