package br.edu.ifpb.ifpbacompanhamento.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Banca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banca_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "banca_sequence", name = "banca_sequence_gen", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private List<Long> professores;
    @Column(nullable = false)
    private Integer coordenadorId;

    @OneToOne
    private Defesa defesa;

    public Banca() {

    }

    public Banca(List<Long> professores, Integer coordenadorId, Defesa defesa) {
        this.professores = professores;
        this.coordenadorId = coordenadorId;
        this.defesa = defesa;
    }

    @Override
    public String toString() {
        return "Banca{" +
                "id=" + id +
                ", professores=" + professores +
                ", coordenadorId=" + coordenadorId +
                ", defesa=" + defesa +
                '}';
    }
}