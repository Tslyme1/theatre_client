package org.nsu.fit.theatre_client.controllers;

import lombok.RequiredArgsConstructor;
import org.nsu.fit.theatre_client.dto.PlayDTO;
import org.nsu.fit.theatre_client.dto.TourDTO;
import org.nsu.fit.theatre_client.services.PlayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/play")
@RequiredArgsConstructor
public class PlayController {
    private final PlayService playService;

    @GetMapping
    public List<PlayDTO> getPlays(){
        return playService.getPlays();
    }
    @GetMapping("/{id}")
    public PlayDTO getPlay(@PathVariable(name = "id") Integer id){
        return playService.getPlay(id);
    }
    @GetMapping("/tour")
    public List<TourDTO> getTours(){
        return playService.getTours();
    }
    @GetMapping("/tour/{id}")
    public TourDTO getTour(@PathVariable(name = "id") Integer id){
        return playService.getTour(id);
    }

    //TODO add put, update and delete
}
