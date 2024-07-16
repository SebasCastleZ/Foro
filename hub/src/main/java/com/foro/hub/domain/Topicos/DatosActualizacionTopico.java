package com.foro.hub.domain.Topicos;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotNull
        Long id,
        String tema,
        String texto) {
}
