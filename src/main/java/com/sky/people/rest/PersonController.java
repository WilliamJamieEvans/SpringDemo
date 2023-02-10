package com.sky.people.rest;

import com.sky.people.domain.Person;
import com.sky.people.personDTO.PersonDTO;
import com.sky.people.personDTO.PersonReqDTO;
import com.sky.people.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    // the service variable is a dependency
    private PeopleService service;

    public PersonController(PeopleService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting() {
        return "Hello, World!";
    }



    @PostMapping("/create")
    public ResponseEntity<PersonDTO> addPerson(@RequestBody @Valid PersonReqDTO person) {

        Person toCreate = new Person(person.getFullName(), person.getOldness(), person.getOccupation(), person.getNotNiNumber());
        Person created = this.service.createPerson(toCreate);
        PersonDTO dto = new PersonDTO(created.getName(), created.getAge(), created.getJob());

        return new ResponseEntity<PersonDTO>(dto, HttpStatus.CREATED);
    }



    @GetMapping("/getAll")
    public List<PersonDTO> getAll() {

        List<Person> found = this.service.getAll();
        List<PersonDTO> dtos = new ArrayList<>();
    // for each Person person in found
        for (Person person : found) {
            PersonDTO dto = new PersonDTO(person.getName(), person.getAge(), person.getJob());
            dtos.add(dto);
        }

        return dtos;
    }



    @GetMapping("/get/{id}")
    public PersonDTO getPerson(@PathVariable int id) { // pulls id from the path(url)

        Person found = this.service.getById(id);
        PersonDTO dto = new PersonDTO(found.getName(), found.getAge(), found.getJob());
        return dto;
    }



    @DeleteMapping("/remove/{id}")
    public PersonDTO removePerson (@PathVariable int id) {

        Person removed = this.service.remove(id);
        PersonDTO dto = new PersonDTO(removed.getName(), removed.getAge(), removed.getJob());
        return dto;
    }




    @PatchMapping("/update/{id}")
    public PersonDTO updatePerson(@PathVariable int id, @PathParam("name") String name, @PathParam("age")Integer age, @PathParam("job")String job) {

        Person removed = this.service.update(id, name, age, job);
        PersonDTO dto = new PersonDTO(removed.getName(), removed.getAge(), removed.getJob());
        return dto;
    }



}
