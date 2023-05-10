package com.unimedTeste.Unimed.Beneficiario.controller;

import com.unimedTeste.Unimed.Beneficiario.entity.Beneficiario;
import com.unimedTeste.Unimed.Beneficiario.service.BeneficiarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/beneficiario")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Beneficiario salvar(@RequestBody Beneficiario beneficiario){
        return beneficiarioService.salvar(beneficiario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Beneficiario> listaBeneficiario(){
        return beneficiarioService.listaBeneficiario();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Beneficiario buscarBeneficiarioPorId(@PathVariable("id") Long id){
        return beneficiarioService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beneficiario nao encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerBeneficiario(@PathVariable("id") Long id){
        beneficiarioService.buscarPorId(id)
                .map(beneficiario -> {
                    beneficiarioService.removerPorId(beneficiario.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beneficiario nao encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarBeneficiario(@PathVariable("id") Long id, @RequestBody Beneficiario beneficiario) {
        beneficiarioService.buscarPorId(id)
                .map(beneficiarioBase -> {
                    modelMapper.map(beneficiario, beneficiarioBase);
                    beneficiarioService.salvar(beneficiarioBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beneficiario nao encontrado."));
    }
}
