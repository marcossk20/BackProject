package br.com.marcosantonio.backproject.consulta.repositories;
import br.com.marcosantonio.backproject.consulta.domain.Consulta;
import br.com.marcosantonio.backproject.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
