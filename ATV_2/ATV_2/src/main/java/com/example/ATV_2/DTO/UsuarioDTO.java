package com.example.ATV_2.DTO;
import com.example.ATV_2.Entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

        private long id;
        private String nome;
        private String sobrenome;
        private String cpf;
        private String Email;
        private String Username;
        private int Senha;
        private LocalDate Data_nascimento;

        public Usuario toUsuario() {
                return new Usuario(
                        this.id,
                        this.nome,
                        this.sobrenome,
                        this.cpf,
                        this.Username,
                        this.Email,
                        this.Senha,
                        this.Data_nascimento
                );
        }


        public UsuarioDTO fromUsuario(Usuario usuario) {
                return new UsuarioDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getSobrenome(),
                        usuario.getCpf(),
                        usuario.getUsername(),
                        usuario.getEmail(),
                        usuario.getSenha(),
                        usuario.getData_nascimento()

                );
        }
}

