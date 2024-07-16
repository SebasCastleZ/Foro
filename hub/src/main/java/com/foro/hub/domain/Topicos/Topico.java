package com.foro.hub.domain.Topicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "topicos")
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
        this.fecha = LocalDateTime.now().toString();
    }

    public void actualizarInformacoes(DatosActualizacionTopico datos) {
        if (datos.tema() != null) {
            this.tema = datos.tema();
        }
        if (datos.text() != null) {
            this.texto = datos.text();
        }
            this.fecha = LocalDateTime.now().toString();

    }

    public void eliminar() {
        this.activo = false;
    }
}