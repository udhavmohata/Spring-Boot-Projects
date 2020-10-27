package com.uv.trial.recommendation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@Table(name = "user")
public class UserDTO
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id",unique = true)
    private int userId;

    @Column(name = "mobile_number")

    @NotNull(message = "Mobile Number field cannot be empty.")
    @Size(min = 10,max = 10,message = "Enter a valid Mobile Number.")
    private String mobileNumber;


    @NotNull(message = "Password field cannot be empty.")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Name field cannot be empty")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Gender field cannot be Empty")
    @Column(name = "gender")
    private String gender;
}
