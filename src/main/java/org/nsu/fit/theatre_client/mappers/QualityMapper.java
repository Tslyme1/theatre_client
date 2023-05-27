package org.nsu.fit.theatre_client.mappers;

import org.mapstruct.Mapper;
import org.nsu.fit.theatre_client.dto.QualityDTO;
import org.nsu.fit.theatre_client.entities.QualityEntity;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface QualityMapper {
    QualityDTO map(QualityEntity entity);

    QualityEntity map(QualityDTO dto);
}
