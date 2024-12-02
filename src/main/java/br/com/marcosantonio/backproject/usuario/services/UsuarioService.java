package br.com.marcosantonio.backproject.usuario.services;

import br.com.marcosantonio.backproject.usuario.domain.Usuario;
import br.com.marcosantonio.backproject.usuario.repositories.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return (Usuario)this.usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(Long id) {
        return (Usuario)this.usuarioRepository.findById(id).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado! ID: " + String.valueOf(id));
        });
    }

    public void deleteUsuario(Long id) {
        Usuario usuario = this.buscarUsuario(id);
        this.usuarioRepository.delete(usuario);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario upUsuario = buscarUsuario (id);
        upUsuario.setNomeUsuario(usuario.getNomeUsuario());
        upUsuario.setEmail (usuario.getEmail());
        upUsuario.setTelefone(usuario.getTelefone());
        upUsuario.setDataNascimento(usuario.getDataNascimento());
        upUsuario.setPermissao(usuario.getPermissao());
        return (Usuario)this.usuarioRepository.save(upUsuario);
    }
}