package com.example.task.controller;

import com.example.task.model.request.UserRequest;
import com.example.task.model.response.CustomEntityResponse;
import com.example.task.model.response.EntityResponse;
import com.example.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<?> saveOrUpdate(@Valid  @RequestBody UserRequest userRequest)
    {
        try{

            return new ResponseEntity(new EntityResponse(userService.saveOrUpdate(userRequest),0), HttpStatus.OK);

        }catch (Exception e)
        {

            return new ResponseEntity(new CustomEntityResponse(e.getMessage(),-1),HttpStatus.OK);

        }


    }


    @GetMapping("/getAllRecords")
    public ResponseEntity<?> getAllRecords()
    {
        try {

            return new ResponseEntity(new EntityResponse(userService.getAllRecords(),0),HttpStatus.OK);

        }catch (Exception e)
        {
            return new ResponseEntity(new CustomEntityResponse(e.getMessage(),-1),HttpStatus.OK);

        }


    }

    @GetMapping("/searchByEmailUserIdUserName")
    public ResponseEntity<?> searchByEmailUserIdUserName(@RequestParam(defaultValue = "0",required = false) Integer pageNo,
                                                         @RequestParam(defaultValue = "10",required = false)Integer pageSize,
                                                         @RequestParam(required = false) String search)
    {
    try{

      //  Pageable pageable = PageRequest.of(pageNo,pageSize);
        Pageable pageable = PageRequest.of(Optional.ofNullable(pageNo).orElse(0), Optional.ofNullable(pageSize).orElse(10));


        return new ResponseEntity(new EntityResponse(userService.searchByEmailUserIdUserName(search,pageable),0),HttpStatus.OK);

    }catch (Exception e)
    {

   return new ResponseEntity(new CustomEntityResponse(e.getMessage(),-1),HttpStatus.OK);
    }




    }

}
