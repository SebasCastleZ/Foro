package com.foro.hub.domain.Topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAllByActivoTrue(Pageable paginacion);

    @Query("""
            select e.activo
            from Topico e
            where e.id=:idTopico 
            """)
    Boolean findActivoById(Long idTopico);
}
