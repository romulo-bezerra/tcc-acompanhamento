package br.edu.ifpb.ifpbacompanhamento.repository;

import br.edu.ifpb.ifpbacompanhamento.domain.ComentarioBanca;
import br.edu.ifpb.ifpbacompanhamento.domain.MaterialApoio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MaterialApoioRepository extends JpaRepository<MaterialApoio, Integer> {

    public Optional<MaterialApoio> findById(@Param("id") Long id);

}
