package com.bodyashah.userservice.controller.v1;

import com.bodyashah.userservice.dto.request.UserRequest;
import com.bodyashah.userservice.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
public interface UserController {

    @RequestMapping(
            produces = "application/json",
            method = RequestMethod.GET)
    ResponseEntity<List<UserResponse>> getAllUsers();

    @RequestMapping(
            produces = "application/json",
            method = RequestMethod.POST)
    ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest);

}
