package com.br.ayrton.funcionariothymeleafcrud.service;

import com.br.ayrton.funcionariothymeleafcrud.modelo.Funcionario;
import com.br.ayrton.funcionariothymeleafcrud.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcionario> buscarTodosFuncionarios(){
        return repository.findAll();
    }

    public void salvar(Funcionario funcionario){
        repository.save(funcionario);
    }

    public Funcionario buscarPorId(Long id){
        Optional<Funcionario> optionalFuncionario = repository.findById(id);
        if (!optionalFuncionario.isPresent()){
            throw new RuntimeException("O funcionário de id: " + id + "não existe");
        }
        Funcionario funcionario = optionalFuncionario.get();
        return funcionario;
    }

    public void deletarPorId(Long id){
        repository.deleteById(id);
    }
}
