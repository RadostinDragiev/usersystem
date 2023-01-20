package com.usersystem.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @NotNull
    @Size(min = 4, max = 30)
    private String username;

    @NotNull
    @Size(min = 5, max = 50)
    @Pattern(regexp = "[A-Za-z1-9!@#$%^&*()?]")
    private String password;

    @NotNull
    @Email
    private String email;

    @Column(name = "registered_on")
    private LocalDate registeredOn;

    @Column(name = "lastT_time_logged_in")
    private LocalDateTime lastTimeLoggedIn;

    private int age;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne
    private Town bornTown;

    @ManyToOne
    private Town currentTown;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Transient
    private String fullName = firstName + lastName;

    @OneToMany
    private Set<User> friends;
}
