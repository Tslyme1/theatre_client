package org.nsu.fit.theatre_client.services;

import lombok.RequiredArgsConstructor;
import org.nsu.fit.theatre_client.dto.EventDTO;
import org.nsu.fit.theatre_client.dto.RepertoireDTO;
import org.nsu.fit.theatre_client.entities.EventEntity;
import org.nsu.fit.theatre_client.entities.RepertoireEntity;
import org.nsu.fit.theatre_client.entities.RepertoireeventmapEntity;
import org.nsu.fit.theatre_client.repositories.EmployeeRepository;
import org.nsu.fit.theatre_client.repositories.EventRepository;
import org.nsu.fit.theatre_client.repositories.RepertoireRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RepertoireService {
    RepertoireRepository repertoireRepository;
    EventRepository eventRepository;
    EmployeeService employeeService;
    PlayService playService;
    private final EmployeeRepository employeeRepository;

    public List<RepertoireDTO> getRepertoires(){
        List<RepertoireDTO> repertoireDTOS = new ArrayList<>();

        List<RepertoireEntity> repertoireEntities = repertoireRepository.findAll();
        for(RepertoireEntity entity : repertoireEntities){
            repertoireDTOS.add(createRepertoireDTO(entity));
        }

        return repertoireDTOS;
    }
    public RepertoireDTO getRepertoire(Integer id){
        Optional<RepertoireEntity> repertoireEntity = repertoireRepository.findById(id);
        if(repertoireEntity.isEmpty()){
            throw new RuntimeException("No repertoire with id: " + id);
        }
        return createRepertoireDTO(repertoireEntity.get());
    }

    public List<EventDTO> getEvents(){
        List<EventDTO> eventDTOS = new ArrayList<>();

        List<EventEntity> eventEntities = eventRepository.findAll();
        for(EventEntity eventEntity : eventEntities){
            eventDTOS.add(createEventDTO(eventEntity));
        }

        return eventDTOS;
    }
    public EventDTO getEvent(Integer id){
        Optional<EventEntity> eventEntity = eventRepository.findById(id);
        if (eventEntity.isEmpty()){
            throw new RuntimeException("No event with id: " + id);
        }
        return createEventDTO(eventEntity.get());
    }

    //private methods
    private RepertoireDTO createRepertoireDTO(RepertoireEntity repertoireEntity){
        RepertoireDTO repertoireDTO = new RepertoireDTO();

        repertoireDTO.setId(repertoireEntity.getId());
        repertoireDTO.setApproved(repertoireEntity.isApproved());
        repertoireDTO.setApproved_by(employeeService.createDTO(employeeRepository.getReferenceById(repertoireEntity.getDirectorByApprovedBy().getEmployeeId())));


        List<EventDTO> eventDTOS = new ArrayList<>();
        for(RepertoireeventmapEntity entity : repertoireEntity.getRepertoireeventmapsById()){
            eventDTOS.add(createEventDTO(entity.getEventByEventId()));
        }
        repertoireDTO.setEvents(eventDTOS);

        return repertoireDTO;
    }

    private EventDTO createEventDTO(EventEntity eventEntity){
        EventDTO eventDTO = new EventDTO();

        eventDTO.setId(eventEntity.getId());
        eventDTO.setPlay(playService.getPlay(eventEntity.getPlayByPlayId().getId()));
        eventDTO.setApprovedBy(employeeService.getDirector(eventEntity.getDirectorByApprovedBy().getEmployeeId()));
        eventDTO.setStartDate(eventEntity.getStartDt());
        eventDTO.setEndDate(eventDTO.getEndDate());
        eventDTO.setSeatsLeft(eventEntity.getSeatsLeft());
        eventDTO.setPremiere(eventEntity.isPremiere());
        eventDTO.setApproved(eventEntity.isApproved());

        return eventDTO;
    }
}
