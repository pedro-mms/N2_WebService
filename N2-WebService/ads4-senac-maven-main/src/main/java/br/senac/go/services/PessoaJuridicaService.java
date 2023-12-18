package br.senac.go.services;

import br.senac.go.domain.PessoaJuridica;
import br.senac.go.generics.IService;
import br.senac.go.repositories.PessoaJuridicaRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PessoaJuridicaService implements IService<PessoaJuridica, Integer> {

    @Autowired
    private PessoaJuridicaRespository pessoaJuridicaRespository;

    @Override
    public PessoaJuridica create(PessoaJuridica entity) {
        return pessoaJuridicaRespository.save(entity)
    }

    @Override
    public PessoaJuridica readById(Integer id) throws Exception {
        return pessoaJuridicaRespository.findAllById(id).orElseThrow(() -> new Exception("Pessoa Jurídica não encontrada"));
    }

    @Override
    public PessoaJuridica read(PessoaJuridica entity) throws Exception {
        return this.readById(entity.getId());
    }

    @Override
    public PessoaJuridica updatePatch(PessoaJuridica entity, Integer id) throws Exception {
        PessoaJuridica pessoaJuridica= this.readById(id);
        PessoaJuridica.setPessoa(entity.getPessoa());
        PessoaJuridica.SetCnpj(entity.getCnpj());

        return pessoaJuridicaRespository.save(pessoaJuridica);
    }

    @Override
    public PessoaJuridica updatePut(PessoaJuridica entity, Integer id) throws Exception{
        if (pessoaJuridicaRespository.findAllById(id).isPresent()){
            return  pessoaJuridicaRespository.save(entity);
        } else throw new Exception("Pessoa Jurídica NÃO Encontrada!");
    }

    @Override
    public void deleteById (Integer id) {
        pessoaJuridicaRespository.deleteById(id);
    }

    public void delete(PessoaJuridica entity) {
        pessoaJuridicaRespository.delete(entity);
    }
}
