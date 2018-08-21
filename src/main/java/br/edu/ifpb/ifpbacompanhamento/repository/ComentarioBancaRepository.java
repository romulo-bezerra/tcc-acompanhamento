package br.edu.ifpb.ifpbacompanhamento.repository;

import br.edu.ifpb.ifpbacompanhamento.domain.ComentarioBanca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ComentarioBancaRepository extends JpaRepository<ComentarioBanca, Integer> {

    public Optional<ComentarioBanca> findById(@Param("id") Long id);

}
