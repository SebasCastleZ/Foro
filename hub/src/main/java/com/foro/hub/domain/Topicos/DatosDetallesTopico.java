package com.foro.hub.domain.Topicos;


public record DatosDetallesTopico(Long id, String tema, String texto, String fecha) {

    public DatosDetallesTopico(Topico tema) {
        this(tema.getId(), tema.getTema(), tema.getTexto(), tema.getFecha());
    }
}
