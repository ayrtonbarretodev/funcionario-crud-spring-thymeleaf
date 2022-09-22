package com.br.ayrton.funcionariothymeleafcrud.repository;

import com.br.ayrton.funcionariothymeleafcrud.modelo.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
