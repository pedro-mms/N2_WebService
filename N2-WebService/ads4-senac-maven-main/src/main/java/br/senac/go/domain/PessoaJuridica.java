package br.senac.go.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "pessoa_juridica")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class PessoaJuridica extends BaseModel {

    private String cnpj;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pessoa pessoa;
}
