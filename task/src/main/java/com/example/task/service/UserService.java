package com.example.task.service;

import com.example.task.model.request.UserRequest;
import org.springframework.data.domain.Pageable;

public interface UserService {


    Object saveOrUpdate(UserRequest userRequest);


    Object getAllRecords();


    Object searchByEmailUserIdUserName(String search, Pageable pageable);
}
