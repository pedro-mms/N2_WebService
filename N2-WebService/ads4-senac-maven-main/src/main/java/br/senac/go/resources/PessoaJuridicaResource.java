package br.senac.go.resources;

import br.senac.go.domain.PessoaJuridica;
import br.senac.go.generics.GenericOperationsResource;
import br.senac.go.services.PessoaJuridicaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controlador com REST
@RequestMapping(path = "/pessoaJuridica")
@Api(value = "Operações para manipulação dos dados de pessoa",
        tags = "pessoaJuridica")
public class PessoaJuridicaResource implements GenericOperationsResource<PessoaJuridica, Integer> {
    /**
     * Quando a pessoa for mandar um post, a aplicação
     * recebe uma entidade(E) e retorna a entidade (e) com o campo
     * id preenchido
     *
     * @param entity
     * @return
     */

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @Override
    @PostMapping("/create")
    public PessoaJuridica post(@RequestBody PessoaJuridica entity) {
        return pessoaJuridicaService.create(entity);
    }

    /**
     * Retorna uma lista de entidades
     *
     * @return
     */
    @Override
    @GetMapping("/read/all")
    public List<PessoaJuridica> get() {
        return null;
    }

    @Override
    @GetMapping("/read")
    public PessoaJuridica get(@RequestBody PessoaJuridica entity) throws Exception{
        return pessoaJuridicaService.read(entity);
    }

    /**
     * Atualiza TODO o registro
     *
     * @param entity
     * @param id
     */

    @Override
    @PutMapping("/update/all/{id}")
    public PessoaJuridica put(@RequestBody PessoaJuridica entity, @PathVariable ("id") Integer id) throws Exception {
        return pessoaJuridicaService.updatePut(entity, id);
    }

    /**
     * Atualiza parcialmente um registro
     *
     * @param entity
     * @param id
     */
    @Override
    @PatchMapping("/update/patch/{id}")
    public void PessoaJuridica patch(@RequestBody PessoaJuridica entity, @PathVariable ("id") Integer id) throws Exception {
        return pessoaJuridicaService.updatePatch(entity, id);
    }

    /**
     * Deleta um registro no banco;
     *
     * @param entity
     */
    @Override
    @DeleteMapping
    public void delete(@RequestBody PessoaJuridica entity) {
        pessoaJuridicaService.delete(entity);
    }

    /**
     * Deleta um registro no banco pelo identificador
     *
     * @param id
     */
    @Override
    @DeleteMapping ("/{id}")
    public void deleteById(@PathVariable ("id") Integer id) {
        PessoaJuridicaService.deleteById(id);
    }
}
