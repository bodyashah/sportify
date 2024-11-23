package com.bodyashah.userservice.dto.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
public class UserRequest {

    private String email;

}
