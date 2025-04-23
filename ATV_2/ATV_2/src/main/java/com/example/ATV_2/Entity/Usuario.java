package com.example.ATV_2.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long Id;
    private  String Nome;
    private  String Sobrenome;
    @Column(unique = true) //a column deixa o  CPF como  único
    private String cpf;
    private String Email;
    private String Username;
    private int Senha;
    private LocalDate Data_nascimento;

    //@JsonIgnore//ignora o atributo
    //private List<Usuario> usuarios;

}
