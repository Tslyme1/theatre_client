package org.nsu.fit.theatre_client.services;

import lombok.RequiredArgsConstructor;
import org.nsu.fit.theatre_client.dto.*;
import org.nsu.fit.theatre_client.entities.*;
import org.nsu.fit.theatre_client.mappers.QualityMapper;
import org.nsu.fit.theatre_client.repositories.PlayRepository;
import org.nsu.fit.theatre_client.repositories.RoleRepository;
import org.nsu.fit.theatre_client.repositories.TourRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayService {
    private final PlayRepository playRepository;
    private final TourRepository tourRepository;
    private final EmployeeService employeeService;
    private final QualityMapper qualityMapper;
    public List<PlayDTO> getPlays(){
        List<PlayDTO> playDTOS = new ArrayList<>();

        List<PlayEntity> playEntities = playRepository.findAll();
        for(PlayEntity playEntity : playEntities){
            playDTOS.add(createPlayDTO(playEntity));
        }
        return playDTOS;
    }
    public PlayDTO getPlay(Integer id){
        Optional<PlayEntity> playEntity = playRepository.findById(id);
        if(playEntity.isEmpty()){
            throw new RuntimeException("no play with id: " + id);
        }
        return createPlayDTO(playEntity.get());
    }

    public List<TourDTO> getTours(){
        List<TourDTO> tourDTOS = new ArrayList<>();

        List<TourEntity> tourEntities = tourRepository.findAll();
        for(TourEntity entity : tourEntities){
            tourDTOS.add(createTourDTO(entity));
        }
        return tourDTOS;
    }
    public TourDTO getTour(Integer id){
        Optional<TourEntity> tourEntity = tourRepository.findById(id);
        if(tourEntity.isEmpty()){
            throw new RuntimeException("no tour with id: " + id);
        }
        return createTourDTO(tourEntity.get());
    }


    //private classes
    private PlayDTO createPlayDTO(PlayEntity playEntity){
        PlayDTO playDTO = new PlayDTO();

        playDTO.setId(playEntity.getId());
        playDTO.setCreatedDate(playEntity.getCreatedDt());
        playDTO.setGenre(playEntity.getGenre());
        playDTO.setMinAge(playEntity.getMinAge());

        Collection< PlayauthormapEntity> playAuthorMapEntities = playEntity.getPlayauthormapsById();
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        for(PlayauthormapEntity entity : playAuthorMapEntities){
            AuthorEntity authorEntity = entity.getAuthorByAuthorId();
            AuthorDTO authorDTO = new AuthorDTO();

            authorDTO.setId(authorEntity.getId());
            authorDTO.setFirstName(authorEntity.getFirstName());
            authorDTO.setLastName(authorEntity.getLastName());
            authorDTO.setPatronymicName(authorEntity.getPatronymicName());
            authorDTO.setCountry(authorEntity.getCountry());
            authorDTO.setBirthDate(authorEntity.getBirthDt());

            authorDTOS.add(authorDTO);
        }

        playDTO.setAuthor(authorDTOS);

        Collection<RoleplaymapEntity> rolePlayMapEntities = playEntity.getRoleplaymapsById();
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for(RoleplaymapEntity entity : rolePlayMapEntities){
            RoleEntity roleEntity = entity.getRoleByRoleId();
            RoleDTO roleDTO = new RoleDTO();

            roleDTO.setId(roleEntity.getId());
            roleDTO.setActor(employeeService.getActor(roleEntity.getActorByActorId().getId()));
            roleDTO.setBackup(employeeService.getActor(roleEntity.getActorByBackup().getId()));
            roleDTO.setName(roleEntity.getName());
            roleDTO.setIs_main(roleEntity.isMain());
            roleDTO.setQuality(qualityMapper.map(roleEntity.getQualityByQualityId()));

            roleDTOS.add(roleDTO);
        }
        playDTO.setRoles(roleDTOS);

        Collection<PlaydirectormapEntity> playDirectorMapEntities = playEntity.getPlaydirectormapsById();
        List<EmployeeDTO> directors = new ArrayList<>();
        for(PlaydirectormapEntity entity : playDirectorMapEntities){
            directors.add(employeeService.getDirector(entity.getDirectorByDirectorId().getEmployeeId()));
        }
        playDTO.setDirectors(directors);

        Collection<PlaymusicianmapEntity> playMusicianMapEntities = playEntity.getPlaymusicianmapsById();
        List<EmployeeDTO> musicians = new ArrayList<>();
        for (PlaymusicianmapEntity entity : playMusicianMapEntities){
            musicians.add(employeeService.getMusician(entity.getMusicianByMusicianId().getEmployeeId()));
        }
        playDTO.setMusicians(musicians);

        Collection<PlayproducermapEntity> playProducerMapEntities = playEntity.getPlayproducermapsById();
        List<EmployeeDTO> producers = new ArrayList<>();
        for(PlayproducermapEntity entity : playProducerMapEntities){
            producers.add(employeeService.getProducer(entity.getProducerByProducerId().getEmployeeId()));
        }
        playDTO.setProducers(producers);

        return playDTO;
    }

    private TourDTO createTourDTO(TourEntity tourEntity){
        TourDTO tourDTO = new TourDTO();
        tourDTO.setId(tourEntity.getId());
        tourDTO.setStartDate(tourEntity.getStartDt());
        tourDTO.setEndDate(tourEntity.getEndDt());
        tourDTO.setPlay(createPlayDTO(tourEntity.getPlayByPlayId()));
        return tourDTO;
    }
}
