/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orangebank.api.orangebankapi.views;

import com.orangebank.api.orangebankapi.controllers.ClientController;
import com.orangebank.api.orangebankapi.models.entity.ClientEntity;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Solange
 */
@RestController
@RequestMapping(path = "/cliente")
public class ClientViewController {
    @Autowired
    ClientController clientController;
    
    @GetMapping(path = "/listar")
    public List <ClientEntity> listarCliente(){
        return clientController.listarCliente();
    }
    @PostMapping(path = "/cadastrar")
    public ResponseEntity<ClientEntity> cadastrarCliente(@RequestBody ClientEntity cadastrar){
        return clientController.cadastrarCliente(cadastrar);
    }
}
