package com.bodyashah.userservice.mapper;

import com.bodyashah.userservice.dto.request.UserRequest;
import com.bodyashah.userservice.dto.response.UserResponse;
import com.bodyashah.userservice.entity.User;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class UserMapper {

    public UserResponse toUserResponse(final User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }

    public User toUser(final UserRequest userRequest) {
        return User.builder()
                .email(userRequest.getEmail())
                .build();
    }

}
