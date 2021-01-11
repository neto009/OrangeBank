/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orangebank.api.orangebankapi.controllers.repository;

import com.orangebank.api.orangebankapi.models.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Solange
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    
}
