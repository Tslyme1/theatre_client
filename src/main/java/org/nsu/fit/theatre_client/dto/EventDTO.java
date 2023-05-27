package org.nsu.fit.theatre_client.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class EventDTO {
    Integer id;
    PlayDTO play;
    EmployeeDTO approvedBy;
    Timestamp startDate;
    Timestamp endDate;
    Integer seatsLeft;
    Boolean premiere;
    Boolean approved;
}
