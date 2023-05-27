package org.nsu.fit.theatre_client.dto;

import lombok.Data;
import org.springframework.data.util.Pair;

import java.sql.Date;
import java.util.List;

@Data
public class EmployeeDTO {
    Integer id;
    String firstName;
    String lastName;
    String patronymicName;
    Date birthDate;
    Integer kidsCount;
    String gender;
    Integer salary;
    String dateJoined;

    Integer invitedBy;
    List<Pair<String, String>> attributes;
    List<String> categories;
}
