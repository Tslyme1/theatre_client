package org.nsu.fit.theatre_client.dto;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class PlayDTO {
    Integer id;
    Date createdDate;
    String genre;
    Integer minAge;

    List<AuthorDTO> author;
    List<RoleDTO> roles;
    List<EmployeeDTO> directors;
    List<EmployeeDTO> musicians;
    List<EmployeeDTO> producers;

}
