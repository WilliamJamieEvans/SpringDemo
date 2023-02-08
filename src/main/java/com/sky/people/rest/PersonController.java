package com.sky.people.rest;

import com.sky.people.domain.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private List<Person> people = new ArrayList<>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting() {
        return "Hello, World!";
    }

    @PostMapping("/create")
    public Person addPerson(@RequestBody Person person) {
        this.people.add(person); // ad a new person to the list
        return this.people.get(this.people.size() - 1); // return the last person in the list
    }


    @GetMapping("/getAll")
    public List<Person> getAll() {
        return this.people;
    }

    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable int id) { // pulls id from the path(url)
        System.out.println("id: " + id);
        return this.people.get(id);
    }


}
