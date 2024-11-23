package com.bodyashah.userservice.controller.v1.impl;

import com.bodyashah.userservice.controller.v1.UserController;
import com.bodyashah.userservice.dto.request.UserRequest;
import com.bodyashah.userservice.dto.response.UserResponse;
import com.bodyashah.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @Override
    public ResponseEntity<UserResponse> createUser(final UserRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }
}
