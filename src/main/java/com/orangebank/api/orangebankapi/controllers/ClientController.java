/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orangebank.api.orangebankapi.controllers;

import com.orangebank.api.orangebankapi.controllers.repository.ClientRepository;
import com.orangebank.api.orangebankapi.models.entity.ClientEntity;
import java.util.List;
import javax.validation.Valid;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Solange
 */
@Component("clientController")
public class ClientController {
    @Autowired
    ClientRepository repository;
    public ClientController() {
    }
    
    public List <ClientEntity> listarCliente(){
        return repository.findAll();
    }
    
    public ResponseEntity cadastrarCliente(ClientEntity cadastrar){
        if(verifyEmail(cadastrar.getEmail())){
            return new ResponseEntity("O email \""+ cadastrar.getEmail() +"\" já esta sendo usado.",HttpStatus.BAD_REQUEST);
        }
        if(verifyCpf(cadastrar.getCpf())){
            return new ResponseEntity("O CPF \""+ cadastrar.getCpf() +"\" já esta sendo usado.",HttpStatus.BAD_REQUEST);
        }
        
        if (cadastrar.getErrorMessage() != null){
            return ResponseEntity.badRequest().body(cadastrar.getErrorMessage());
        }
        ClientEntity client = repository.save(cadastrar);
        return new ResponseEntity(client,HttpStatus.CREATED);
    }
    
    private Boolean verifyEmail (String email){
        List <ClientEntity> lista = listarCliente();
        for(int i=lista.size()-1; i>=0; i--){
            if(lista.get(i).getEmail().equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
    }
    
    private Boolean verifyCpf (String cpf){
        List <ClientEntity> lista = listarCliente();
        for(int i=lista.size()-1; i>=0; i--){
            if(lista.get(i).getCpf().equalsIgnoreCase(cpf)){
                return true;
            }
        }
        return false;
    }
    
    
}
