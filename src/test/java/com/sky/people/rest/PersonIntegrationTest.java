package com.sky.people.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.people.domain.Person;
import com.sky.people.personDTO.PersonDTO;
import com.sky.people.personDTO.PersonReqDTO;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // loads the app context with all your beans
@AutoConfigureMockMvc // sets up the testing library
@Sql(scripts = {"classpath:person-schema.sql", "classpath:person-data.sql"})
public class PersonIntegrationTest {


    @Autowired // tells Spring to inject the mvc object into my test class
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    void testCreate() throws Exception{
        //SETTING UP THE REQUEST
        PersonReqDTO newPerson = new PersonReqDTO("TEST William", 29, "TEST Software Engineer", "TEST 1116 FG5");
        String newPersonJSON = this.mapper.writeValueAsString(newPerson);
        System.out.println("JSON:" + newPersonJSON);

        //METHOD, URL, BODY, CONTENT-TYPE
        RequestBuilder req = MockMvcRequestBuilders
                .post("/create")
                .content(newPersonJSON)
                .contentType(MediaType.APPLICATION_JSON);

        //CHECK THE RESPONSE STATUS
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        PersonDTO created = new PersonDTO("TEST William", 29,"TEST Software Engineer");
        //CHECK THE RESPONSE BODY
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(created));
        // DO THE REQ AND CHECK THE RESPONSE

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testGet() throws Exception{
        //SETTING UP THE REQUEST
        RequestBuilder req = MockMvcRequestBuilders.get("/get/1");
        //CHECK THE RESPONSE STATUS
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        PersonDTO person = new PersonDTO("NameTEST", 24,"SQLTEST");
        //CHECK THE RESPONSE BODY
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(person));
        // DO THE REQ AND CHECK THE RESPONSE
        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testRemove() throws Exception{
        //SETTING UP THE REQUEST
        RequestBuilder req = MockMvcRequestBuilders.delete("/remove/1");
        //CHECK THE RESPONSE STATUS
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        PersonDTO person = new PersonDTO("NameTEST", 24,"SQLTEST");
        //CHECK THE RESPONSE BODY
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(person));
        // DO THE REQ AND CHECK THE RESPONSE
        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testUpdate() throws Exception{
        //SETTING UP THE REQUEST
        RequestBuilder req = MockMvcRequestBuilders.patch("/update/1");
        //CHECK THE RESPONSE STATUS
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        PersonDTO person = new PersonDTO("NameTEST", 24,"SQLTEST");
        //CHECK THE RESPONSE BODY
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(person));
        // DO THE REQ AND CHECK THE RESPONSE
        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testGetAll() throws Exception{
        //SETTING UP THE REQUEST
        RequestBuilder req = MockMvcRequestBuilders.get("/getAll");
        //CHECK THE RESPONSE STATUS
        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        PersonDTO person = new PersonDTO("NameTEST", 24,"SQLTEST");
        List<PersonDTO> personList = new ArrayList<>();
        personList.add(person);
        //CHECK THE RESPONSE BODY
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(personList));
        // DO THE REQ AND CHECK THE RESPONSE
        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }


}