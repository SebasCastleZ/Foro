package com.foro.hub.domain.Topicos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DatosRegistroTopico(
        @NotBlank
        String tema,
        @NotBlank
        @Email
        String texto,
        @NotBlank
        String fecha) {
}
