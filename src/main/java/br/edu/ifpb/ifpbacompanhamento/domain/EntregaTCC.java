package br.edu.ifpb.ifpbacompanhamento.domain;

import br.edu.ifpb.ifpbacompanhamento.domain.enums.TipoEntrega;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class EntregaTCC {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entregatcc_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "entregatcc_sequence", name = "entregatcc_sequence_gen", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private ZonedDateTime dataHoraMax;
    @Column(nullable = false)
    private String comunicado;
    @Column(nullable = false)
    private Long TCCId;
    @Column(nullable = false)
    private Long coordenadorId;
    @Column(nullable = false)
    @Enumerated
    private TipoEntrega tipoEntrega;

    @OneToMany
    private List<Documento> documentos;

    public EntregaTCC() {

    }

    public EntregaTCC(ZonedDateTime dataHoraMax, String comunicado, Long TCCId, Long coordenadorId, TipoEntrega tipoEntrega, List<Documento> documentos) {
        this.dataHoraMax = dataHoraMax;
        this.comunicado = comunicado;
        this.TCCId = TCCId;
        this.coordenadorId = coordenadorId;
        this.tipoEntrega = tipoEntrega;
        this.documentos = documentos;
    }

    @Override
    public String toString() {
        return "EntregaTCC{" +
                "id=" + id +
                ", dataHoraMax=" + dataHoraMax +
                ", comunicado='" + comunicado + '\'' +
                ", TCCId=" + TCCId +
                ", coordenadorId=" + coordenadorId +
                ", tipoEntrega=" + tipoEntrega +
                ", documentos=" + documentos +
                '}';
    }
}