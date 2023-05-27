package org.nsu.fit.theatre_client.dto;

import lombok.Data;

import java.util.List;

@Data
public class RepertoireDTO {
    Integer id;
    Boolean approved;
    EmployeeDTO approved_by;
    List<EventDTO> events;
}
