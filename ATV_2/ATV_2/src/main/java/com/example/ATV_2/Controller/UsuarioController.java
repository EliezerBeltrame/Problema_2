package com.example.ATV_2.Controller;

import com.example.ATV_2.DTO.UsuarioDTO;
import com.example.ATV_2.Entity.Usuario;
import com.example.ATV_2.Service.UsuarioService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
        @Autowired
        private UsuarioService usuarioService;

        // buscar todos os usuarios
        //@GetMapping
        //public ResponseEntity<List<Usuario>> getAll() {return ResponseEntity.status(HttpStatus.OK).body(UsuarioService.getAll());

      // }
         @JsonIgnore//ignora o atributo
         private List<Usuario> getAll(){
             return usuarioService.getAllUsuarios();

         }

        // busca um cliente por ID
        @GetMapping("/{id}")
        public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id) {
            Optional<UsuarioDTO> clienteDTO = usuarioService.getById(id);
            if(clienteDTO.isPresent()){
                return ResponseEntity.ok(clienteDTO.get());
            }else {
                return ResponseEntity.notFound().build();
            }
        }

        //criar um novo cliente
        @PostMapping
        public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
            UsuarioDTO cliente = usuarioService.save(usuarioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
        }

        // atualiza um cliente existente
        @PutMapping("/{id}")
        public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
            Optional<UsuarioDTO> usuarioDTOOptional = usuarioService.updateUsuario(id,usuarioDTO);
            if(usuarioDTOOptional.isPresent()){
                return ResponseEntity.ok(usuarioDTOOptional.get());
            }else{
                return ResponseEntity.notFound().build();
            }
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            if (usuarioService.delete(id)) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
    }


