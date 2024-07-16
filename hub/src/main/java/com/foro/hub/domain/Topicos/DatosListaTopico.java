package com.foro.hub.domain.Topicos;

public record DatosListaTopico(Long id, String tema, String texto, String fecha) {

    public DatosListaTopico(Topico tema) {
        this(tema.getId(), tema.getTema(), tema.getTexto(), tema.getFecha());
    }

}
