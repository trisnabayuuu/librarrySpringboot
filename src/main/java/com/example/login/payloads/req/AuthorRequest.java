package com.example.login.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AuthorRequest {

    @NotEmpty(message = "nama author tidak boleh kosong")
    private String authorName;

    @NotEmpty(message = "social media author tidak boleh kosong")
    private String socialMedia;

}
