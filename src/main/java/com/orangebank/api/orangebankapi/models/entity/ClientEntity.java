/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orangebank.api.orangebankapi.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author Solange
 */
@Entity //transformar a classe abaixo em entidade para o db.
@Table(name = "cliente") //tabela do banco de dados.
public class ClientEntity implements Serializable {
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id;
    @NotNull (message="O nome nao pode ser vazio ou nulo.")
    @Size(min = 5, max = 200, message = "Nome não pode ter menos de 5 letras")
    private String name;
    @NotNull (message="O e-mail nao pode ser vazio ou nulo.")
    @Email(message="Email tem que ser valido")
    @NotBlank(message="O campo nao pode estar vazio")
    private String email;
    @NotNull (message="O CPF nao pode nulo.")
    @Size(min = 11, max = 11, message = "O CPF tem que ser igual a 11 numeros")
    private String cpf;
    @NotNull (message="A data de nascimento nao pode ser vazio ou nulo.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

    public ClientEntity(Long id, String name, String email, String cpf, Date nascimento) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public ClientEntity(String name, String email, String cpf, Date nascimento) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public ClientEntity() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    public String getErrorMessage(){
        if (this.getName() == null){
            return "O nome nao pode nulo.";
        }
        if (this.getName().isEmpty()){
            return "E obrigatorio o preenchimento do nome.";
        }
        if (this.getName().length() <= 4 || this.getName().length() >=200){
            return "O nome não pode ter menos de 5 letras ou mais que 200.";
        }
        if (this.getCpf() == null){
            return "O CPF nao pode nulo.";
        }
        if (this.getCpf().length() < 11 || this.getCpf().length() > 11){
            return "O CPF esta incorreto, necessario 11 numeros";
        }
        if (!isNumber(this.getCpf())){
            return "O CPF deve conter apenas numeros.";
        }
        if (!this.getEmail().contains("@")){
            return "Email tem que ser valido.";
        }
        return null;
    }
    
    private Boolean isNumber(String value){
        try {
            Long n = Long.parseLong(value);
        } catch(NumberFormatException error){
            return false;
        }
        return true;
    }
}
