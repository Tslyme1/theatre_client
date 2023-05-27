package org.nsu.fit.theatre_client.controllers;

import lombok.RequiredArgsConstructor;
import org.nsu.fit.theatre_client.repositories.EmployeeRepository;
import org.nsu.fit.theatre_client.repositories.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/query")
@RequiredArgsConstructor
public class QueryController {/*
    QueryRepository queryRepository;
    @GetMapping("/1")
    public List<Object> get1(@RequestParam(name = "gender") String gender){
        return queryRepository.find1(gender);
    }

    @GetMapping("/2")
    public Object get2(){
        return queryRepository.findWorkersCount();
    }

    @GetMapping("/3")
    public List<Object> get3(){
        return queryRepository.findAllPlays();
    }

    @GetMapping("/4")
    public List<Object> get4(){
        return queryRepository.findAllAuthors();
    }

    @GetMapping("/5")
    public List<Object> get5(@RequestParam(name = "genre")String genre){
        return queryRepository.findAllPlayByGenre(genre);
    }

    @GetMapping("/6")
    public List<Object> get6(@RequestParam(name = "role_id") Integer id){
        return queryRepository.findActorsToRole(id);
    }

    @GetMapping("/7")
    public List<Object> get7(){
        return queryRepository.findActorsCount();
    }

    @GetMapping("/8")
    public List<Object> get8(@RequestParam(name = "start")Date start, @RequestParam(name = "end")Date end){
        return queryRepository.findListActorsAndProducers(start, end);
    }

    @GetMapping("/9")
    public List<Object> get9(@RequestParam(name = "play_id")Integer play){
        return queryRepository.findPremiereDate(play);
    }

    @GetMapping("/10")
    public Object get10(@RequestParam(name = "actor_id") Integer actor){
        return queryRepository.findCountActorRoles(actor);
    }

    @GetMapping("/11")
    public Object get11(){
        return queryRepository.findSoldTickets();
    }

    @GetMapping("/12")
    public Object get12(@RequestParam(name = "play_id") Integer play){
        return queryRepository.findPlayRevenue(play);
    }

    @GetMapping("/13")
    public Object get13(){
        return queryRepository.findFreeSeats();
    }*/
}
