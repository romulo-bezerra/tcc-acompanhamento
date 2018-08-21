package br.edu.ifpb.ifpbacompanhamento.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documento_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "documento_sequence", name = "documento_sequence_gen", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String caminho;

    @ManyToOne
    private EntregaTCC entregaTCC;

    public Documento() {

    }

    public Documento(String titulo, String descricao, String caminho, EntregaTCC entregaTCC) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.caminho = caminho;
        this.entregaTCC = entregaTCC;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", caminho='" + caminho + '\'' +
                ", entregaTCC=" + entregaTCC +
                '}';
    }
}