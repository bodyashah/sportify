package com.bodyashah.userservice.service;

import com.bodyashah.userservice.dto.request.UserRequest;
import com.bodyashah.userservice.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> findAllUsers();

    UserResponse createUser(UserRequest userRequest);

}
