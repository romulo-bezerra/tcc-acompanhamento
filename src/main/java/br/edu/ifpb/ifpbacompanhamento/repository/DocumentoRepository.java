package br.edu.ifpb.ifpbacompanhamento.repository;

import br.edu.ifpb.ifpbacompanhamento.domain.ComentarioBanca;
import br.edu.ifpb.ifpbacompanhamento.domain.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

    public Optional<Documento> findById(@Param("id") Long id);

}
