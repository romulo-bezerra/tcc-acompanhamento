package br.edu.ifpb.ifpbacompanhamento.repository;

import br.edu.ifpb.ifpbacompanhamento.domain.ComentarioBanca;
import br.edu.ifpb.ifpbacompanhamento.domain.EntregaTCC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EntregaTCCRepository extends JpaRepository<EntregaTCC, Integer> {

    public Optional<EntregaTCC> findById(@Param("id") Long id);

}
