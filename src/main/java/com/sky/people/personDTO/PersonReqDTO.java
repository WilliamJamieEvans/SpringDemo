package com.sky.people.personDTO;

public class PersonReqDTO {




    private String fullName;
    private Integer oldness;

    private  String occupation;

    private String notNiNumber;



    public PersonReqDTO(String notNiNumber) {
        this.notNiNumber = notNiNumber;
    }


    public String getNotNiNumber() {
        return notNiNumber;
    }

    public void setNotNiNumber(String notNiNumber) {
        this.notNiNumber = notNiNumber;
    }

    public PersonReqDTO(String fullName, Integer oldness, String occupation) {
        this.fullName = fullName;
        this.oldness = oldness;
        this.occupation = occupation;
    }
    public PersonReqDTO(){

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
