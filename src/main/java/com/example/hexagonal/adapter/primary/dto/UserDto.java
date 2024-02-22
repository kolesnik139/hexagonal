package com.example.hexagonal.adapter.primary.dto;

import java.util.Date;
import java.util.Objects;

public class UserDto {
    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto user = (UserDto) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(birthDate, user.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate);
    }
}
