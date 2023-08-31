package com.example.login.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookRequest {
    @NotEmpty(message = "masukkan judul!")
    private String judul;

    @Size(max = 4, message = "Tahun terbit harus 4 character atau yyyy.")
    private String tahunTerbit;

    @NotEmpty(message = "masukkan author!")
    private String namaPengarang;
    private String namaPenerbit;
}
