package com.example.springboot_DataIntegrityViolation_Exception;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="ID",unique = true,updatable = false)
    int id;

    @Column(name="Name",nullable = false)
    @NotNull(message="Name cannot be null")
    @Pattern(regexp = "^[a-zA-Z]+$",message="Special Character not allowed in name")
    String name;

    @Column(name="Phone No",unique = true,nullable = false)
    @NotNull(message="Please Enter a Valid Phone number")
    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message="Please provide An Valid Phone No!")
    String phoneno;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
