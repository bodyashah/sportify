package com.bodyashah.userservice.service.impl;

import com.bodyashah.userservice.dto.request.UserRequest;
import com.bodyashah.userservice.dto.response.UserResponse;
import com.bodyashah.userservice.entity.User;
import com.bodyashah.userservice.mapper.UserMapper;
import com.bodyashah.userservice.repository.UserRepository;
import com.bodyashah.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> findAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream()
                .map(UserMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse createUser(final UserRequest userRequest) {
        User createdUser = userRepository.save(UserMapper.toUser(userRequest));
        return UserMapper.toUserResponse(createdUser);
    }
}
