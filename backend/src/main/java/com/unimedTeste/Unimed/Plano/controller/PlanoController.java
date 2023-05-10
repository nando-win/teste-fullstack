package com.unimedTeste.Unimed.Plano.controller;

import com.unimedTeste.Unimed.Plano.entity.Plano;
import com.unimedTeste.Unimed.Plano.service.PlanoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/plano")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plano salvar(@RequestBody Plano plano){
        return planoService.salvar(plano);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Plano> listaPlano(){
        return planoService.listaPlano();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPlano(@PathVariable("id") Long id){
        planoService.buscarPorId(id)
                .map(plano -> {
                    planoService.removerPorId(plano.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano nao encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPlano(@PathVariable("id") Long id, @RequestBody Plano plano){
        planoService.buscarPorId(id)
                .map(planoBase -> {
                    modelMapper.map(plano, planoBase);
                    planoService.salvar(planoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano nao encontrado."));
    }
}
