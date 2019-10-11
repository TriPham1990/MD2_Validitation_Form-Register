package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;

    @Min(18)
    private int age;

    @Email
    @Pattern(regexp = "^[A-Za-z0-9]+[@][A-Za-z0-9]+\\.[A-Za-z0-9]+$")
    private String email;

    public User() {
    }

    public User(@NotEmpty @Size(min = 5, max = 45) String firstName,
                @NotEmpty @Size(min = 5, max = 45) String lastName,
                @Min(18) int age,
                @Email @Pattern(regexp = "^[A-Za-z0-9]+[@][A-Za-z0-9]+\\.[A-Za-z0-9]+$") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
