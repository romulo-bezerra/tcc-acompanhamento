package br.edu.ifpb.ifpbacompanhamento.repository;

import br.edu.ifpb.ifpbacompanhamento.domain.ComentarioBanca;
import br.edu.ifpb.ifpbacompanhamento.domain.TCC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TCCRepository extends JpaRepository<TCC, Integer> {

    public Optional<TCC> findById(@Param("id") Long id);

}
