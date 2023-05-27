package org.nsu.fit.theatre_client.dto;

import lombok.Data;

@Data
public class RoleDTO {
    Integer id;
    ActorDTO actor;
    ActorDTO backup;
    String name;
    Boolean is_main;
    QualityDTO quality;
}
