package com.example.task.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {

private Long userId;

private String userName;

private String email;

private String password;

private String city;

private String state;

private String country;

private String zipCode;


}
