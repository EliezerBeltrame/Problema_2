package com.example.ATV_2.Service;

import com.example.ATV_2.DTO.UsuarioDTO;
import com.example.ATV_2.Entity.Usuario;
import com.example.ATV_2.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Converte de UsuarioDTO para Usuario
    public Usuario fromDTO(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setSobrenome(usuarioDTO.getSobrenome());

        return usuario;
    }

    // Converte Usuario para UsuarioDTO
    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuario.setId(usuarioDTO.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setSobrenome(usuario.getSobrenome());
        usuarioDTO.setCpf(usuario.getCpf());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setSobrenome(usuario.getSobrenome());
        usuarioDTO.setData_nascimento(usuario.getData_nascimento());

        return usuarioDTO;
    }

    // Busca todos os usuarios
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();

    }

    // Busca um usuario pelo ID e retorna o DTO
    public Optional<UsuarioDTO> getById(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            return Optional.of(this.toDTO(optionalUsuario.get()));
        } else {
            return Optional.empty();
        }
    }

    // Salva um novo cliente
    public UsuarioDTO save(UsuarioDTO usuaroDTO) {
        Usuario usuario = this.fromDTO(usuaroDTO);
        Usuario usuarioBd = usuarioRepository.save(usuario);
        return this.toDTO(usuarioBd);
    }

    // Atualiza um cliente existente
    public Optional<UsuarioDTO> updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setId(usuarioDTO.getId());
            usuario.setNome(usuarioDTO.getNome());
            usuario.setSobrenome(usuarioDTO.getSobrenome());
            usuario.setCpf(usuarioDTO.getCpf());
            usuario.setSobrenome(usuarioDTO.getSobrenome());
            usuario.setData_nascimento(usuarioDTO.getData_nascimento());

            Usuario usuarioUpdated = usuarioRepository.save(usuario);
            return Optional.of(this.toDTO(usuarioUpdated));
        } else {
            return Optional.empty();
        }
    }

    // Deleta um cliente pelo ID
    public boolean delete(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
