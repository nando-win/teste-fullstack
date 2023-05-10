package com.unimedTeste.Unimed.Plano.service;

import com.unimedTeste.Unimed.Plano.entity.Plano;
import com.unimedTeste.Unimed.Plano.repository.PlanoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {

    @Autowired
    private PlanoRespository planoRespository;

    public Plano salvar(Plano plano){
        return planoRespository.save(plano);
    }

    public List<Plano> listaPlano(){
        return planoRespository.findAll();
    }

    public Optional<Plano> buscarPorId(Long id){
        return planoRespository.findById(id);
    }

    public void removerPorId(Long id){
        planoRespository.deleteById(id);
    }
}
