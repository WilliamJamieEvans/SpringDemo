package com.sky.people.personDTO;

public class PersonDTO {


    private String fullName;
    private Integer oldness;

    private  String occupation;




    public PersonDTO(String fullName, Integer oldness, String occupation) {
        this.fullName = fullName;
        this.oldness = oldness;
        this.occupation = occupation;
    }
    public PersonDTO(){

    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getOldness() {
        return oldness;
    }

    public void setOldness(Integer oldness) {
        this.oldness = oldness;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }



}
