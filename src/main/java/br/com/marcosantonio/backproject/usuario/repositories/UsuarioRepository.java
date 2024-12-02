package br.com.marcosantonio.backproject.usuario.repositories;
import br.com.marcosantonio.backproject.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
