package com.onlinestore.owndns.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**v1*/
@Setter
@Getter
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
