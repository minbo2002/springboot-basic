package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectDto {

    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    public ObjectDto() {  // default 생성자
        this.name=null;
        this.age=0;
        this.phoneNumber=null;
    }

    public ObjectDto(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "ObjectDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
