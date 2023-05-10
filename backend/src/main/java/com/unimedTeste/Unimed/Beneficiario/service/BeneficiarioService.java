package com.unimedTeste.Unimed.Beneficiario.service;

import com.unimedTeste.Unimed.Beneficiario.entity.Beneficiario;
import com.unimedTeste.Unimed.Beneficiario.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public Beneficiario salvar(Beneficiario beneficiario){
        return beneficiarioRepository.save(beneficiario);
    }

    public List<Beneficiario> listaBeneficiario(){
        return beneficiarioRepository.findAll();
    }

    public Optional<Beneficiario> buscarPorId(Long id){
        return beneficiarioRepository.findById(id);
    }

    public void removerPorId(Long id){
        beneficiarioRepository.deleteById(id);
    }

}
