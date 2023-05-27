package org.nsu.fit.theatre_client.controllers;

import lombok.RequiredArgsConstructor;
import org.nsu.fit.theatre_client.dto.EventDTO;
import org.nsu.fit.theatre_client.dto.RepertoireDTO;
import org.nsu.fit.theatre_client.services.RepertoireService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/repertoire")
@RequiredArgsConstructor
public class RepertoireController {
    private final RepertoireService repertoireService;

    @GetMapping
    public List<RepertoireDTO> getRepertoires(){
        return repertoireService.getRepertoires();
    }
    @GetMapping("/{id}")
    public RepertoireDTO getRepertoire(@PathVariable(name = "id") Integer id){
        return repertoireService.getRepertoire(id);
    }

    @GetMapping("/event")
    public List<EventDTO> getEvents(){
        return repertoireService.getEvents();
    }
    @GetMapping("event/{id}")
    public EventDTO getEvent(@PathVariable(name = "id") Integer id){
        return repertoireService.getEvent(id);
    }


    //TODO add put, update and delete
}
