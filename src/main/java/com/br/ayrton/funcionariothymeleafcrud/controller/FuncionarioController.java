package com.br.ayrton.funcionariothymeleafcrud.controller;

import com.br.ayrton.funcionariothymeleafcrud.modelo.Funcionario;
import com.br.ayrton.funcionariothymeleafcrud.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {
    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("funcionarios", service.buscarTodosFuncionarios());
        return "index";
    }

    @GetMapping("/addnew")
    public String adicionar(Model model){
        Funcionario funcionario = new Funcionario();
        model.addAttribute("funcionario", funcionario);
        return "novofuncionario";
    }

    @PostMapping("/save")
    public String salvar(Funcionario funcionario){
        service.salvar(funcionario);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String atualizar(@PathVariable(value = "id") Long id, Model model){
        Funcionario funcionario = service.buscarPorId(id);
        model.addAttribute("funcionario",funcionario);
        return "update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deletar(@PathVariable(value = "id") Long id){
        service.deletarPorId(id);
        return "redirect:/";
    }
}
