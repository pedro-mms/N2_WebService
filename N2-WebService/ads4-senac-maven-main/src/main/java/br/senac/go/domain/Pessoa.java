package br.senac.go.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@Table(name = "pessoa")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Pessoa extends BaseModel implements Serializable {

    @Column(length = 50, nullable = false)
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("dataInicio")
    private LocalDateTime dataInicio;

    @JsonProperty("dataFim")
    private LocalDateTime dataFim;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatos;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PessoaJuridica> pessoaJuridicas
}
