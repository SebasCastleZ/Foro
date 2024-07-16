package com.foro.hub.domain.Topicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tema;
    private String texto;

    private String fecha;

    private Boolean activo;

    public Topico(DatosRegistroTopico datos) {
        this.activo = true;
        this.tema = datos.tema();
        this.texto = datos.texto();
        this.fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public void actualizarInformacion(DatosActualizacionTopico datos) {
        if (datos.tema() != null) {
            this.tema = datos.tema();
        }
        if (datos.texto() != null) {
            this.texto = datos.texto();
        }
            this.fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

    }

    public void eliminar() {
        this.activo = false;
    }
}