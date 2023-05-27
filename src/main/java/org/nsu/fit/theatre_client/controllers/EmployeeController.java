package org.nsu.fit.theatre_client.controllers;

import lombok.RequiredArgsConstructor;
import org.nsu.fit.theatre_client.dto.ActorDTO;
import org.nsu.fit.theatre_client.dto.EmployeeDTO;
import org.nsu.fit.theatre_client.dto.FullNameDTO;
import org.nsu.fit.theatre_client.entities.EmployeeEntity;
import org.nsu.fit.theatre_client.repositories.EmployeeRepository;
import org.nsu.fit.theatre_client.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;


    @GetMapping("/all")
    public Iterable<EmployeeEntity> getAll(){
        return employeeRepository.findAll();
    }
    @GetMapping("/by_fullname")
    public ResponseEntity<?> getEmployeeByFullName(@RequestBody FullNameDTO name){
        return new ResponseEntity<>(employeeService.findByFullName(name), HttpStatus.OK);
    }
    @GetMapping("/")
    public EmployeeDTO getById(@RequestParam(name = "id") Integer id){
        EmployeeDTO employeeDTO = employeeService.createDTO(employeeRepository.findById(id).get());
        return employeeDTO;
    }
    @GetMapping("/actor")
    public ResponseEntity<?> getActors(){
        return new ResponseEntity<>(employeeService.getActors(), HttpStatus.OK);
    }
    @PostMapping("/actor")
    public ResponseEntity<?> saveActor(@RequestBody ActorDTO actorDTO){
        return new ResponseEntity<>(employeeService.saveActor(actorDTO), HttpStatus.OK);
    }
    @GetMapping("/musician")
    public ResponseEntity<?> getMusician(){
        return new ResponseEntity<>(employeeService.getMusicians(), HttpStatus.OK);
    }
    @GetMapping("/director")
    public ResponseEntity<?> getDirectors(){
        return new ResponseEntity<>(employeeService.getDirectors(), HttpStatus.OK);
    }
    @GetMapping("/producer")
    public ResponseEntity<?> getProducer(){
        return new ResponseEntity<>(employeeService.getProducers(), HttpStatus.OK);
    }
    @PostMapping("/musician")
    public ResponseEntity<?> saveMusician(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.saveMusician(employeeDTO), HttpStatus.OK);
    }
    @PostMapping("/staff")
    public ResponseEntity<?> saveStaff(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.saveStaff(employeeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/actor")
    public void deleteActor(@RequestParam Integer id){
        employeeService.deleteActor(id);
    }
    //TODO add update and delete
}
