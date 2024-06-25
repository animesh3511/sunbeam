package com.example.task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import javax.validation.constraints.Pattern;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // here,username will contain only-> ^ start point, 'a-z' a to z chars in small case,'A-Z' chars in
    //large case,'0-9' numerics,'-' underscore. '+' means username can contain one or more of this chars
    // $ -> end of expression. if this condition is voilated the msg will be displayed
  //  @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username must contain only alphanumeric characters and underscores")
    @Column(name = "user_name")
    private String userName;

    @Column(name = "Email")
    private String email;

   // @Size(min = 5, max = 10,message = "password must be between 5 to 10 characters")
   // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{5,}$",
   //         message = "Password must contain at least one digit, one letter, and one special character")
    @Column(name = "password")
    private String password;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{6,6}$",message = "zipcode must be of 6 Alphanumeric characters")
    @Column(name = "zipcode")
    private String zipCode;



}
