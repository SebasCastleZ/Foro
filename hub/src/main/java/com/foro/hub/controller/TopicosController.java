package com.foro.hub.controller;


import com.foro.hub.domain.Topicos.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
@SuppressWarnings("all")
public class TopicosController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Empezar un nuevo tema")
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriBuilder) {
        var tema = new Topico(datos);
        repository.save(tema);

        var uri = uriBuilder.path("/topiocs/{id}").buildAndExpand(tema.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetallesTopico(tema));
    }

    @GetMapping
    @Operation(summary = "Obtiene el listado para los temas")
    public ResponseEntity<Page<DatosListaTopico>> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
        var page = repository.findAllByActivoTrue(paginacion).map(DatosListaTopico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Actualiza las informaciones para el paciente")
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos) {
        var paciente = repository.getReferenceById(datos.id());
        paciente.actualizarInformacoes(datos);

        return ResponseEntity.ok(new DatosDetallesTopico(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Elimina un tema a partir del ID")
    public ResponseEntity eliminar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.eliminar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "obtiene los detalles para el tema con el ID indicado")
    public ResponseEntity detallar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetallesTopico(paciente));
    }


}

