package br.com.marcosantonio.backproject.usuario.resources;

import br.com.marcosantonio.backproject.usuario.domain.Usuario;
import br.com.marcosantonio.backproject.usuario.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService;

    public UsuarioResource() {
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = this.usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listusuarios() {
        List<Usuario> usuarios = this.usuarioService.listarUsuarios();
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
        Usuario usuario = this.usuarioService.buscarUsuario(id);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping({"/{id}"})
    public void deletarUsuario(@PathVariable Long id) {
        this.usuarioService.deleteUsuario(id);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuario = this.usuarioService.atualizarUsuario(id, usuarioAtualizado);
        return ResponseEntity.ok().body(usuario);
    }
}
