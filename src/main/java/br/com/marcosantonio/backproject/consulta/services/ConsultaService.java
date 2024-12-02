package br.com.marcosantonio.backproject.consulta.services;


import br.com.marcosantonio.backproject.consulta.domain.Consulta;
import br.com.marcosantonio.backproject.consulta.repositories.ConsultaRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ConsultaService {


    private ConsultaRepository consultaRepository;


    public Consulta cadastrarConsulta(Consulta consulta){
        consulta.setIdConsulta(null);
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta buscarConsulta(Long id) {
        Optional<Consulta> consulta = consultaRepository.findById((id));
        return consulta.orElseThrow(() -> new ObjectNotFoundException("Consulta não encontrado! ID: ", id));
    }

    public void deletarConsulta(Long id) throws ExceptionDataIntegrityViolation {
        buscarConsulta(id);
        try {
            consultaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ExceptionDataIntegrityViolation("Não é possível excluir, porque há entidades relacionadas.");
        }
    }

    public Consulta atualizarConsulta(Consulta consulta) {
        Consulta novaConsulta = buscarConsulta(consulta.getIdConsulta());
        updateData(novaConsulta, consulta);
        return consultaRepository.save(novaConsulta);
    }

    private void updateData(Consulta novaConsulta, Consulta consulta){
        novaConsulta.setDataConsulta(consulta.getDataConsulta());
        novaConsulta.setProfissional(consulta.getProfissional());
        novaConsulta.setEspecialidade(consulta.getEspecialidade());
    }
}
