package com.example.login.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {
    @NotEmpty(message = "username tidak boleh kosong")
    private String username;
    
    @NotEmpty(message = "password tidak boleh kosong")
    @Size(min = 8, max = 12, message = "Password must between 8 to 12 characters!")
    private String password;
}
