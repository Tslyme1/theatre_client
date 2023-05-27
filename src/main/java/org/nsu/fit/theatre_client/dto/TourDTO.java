package org.nsu.fit.theatre_client.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class TourDTO {
    Integer id;
    PlayDTO play;
    Date startDate;
    Date endDate;
}
