package com.aisultan.school.components.student.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Students {

    private Integer id;

    public Students() {

    }

    public Students(String name, String surname, Integer course, String advisor, String email) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.advisor = advisor;
        this.email = email;
    }

    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @NotNull
    @Size(min = 2, max = 20)
    private String surname;

    @NotNull
    @Range(min = 1, max = 11)
    private Integer course;

    @NotNull
    @Size(min = 2, max = 20)
    private String advisor;

    @NotEmpty
    @Email
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.surname + " " + this.advisor + " " + this.email + " " + this.course;
    }
}
