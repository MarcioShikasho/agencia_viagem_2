package com.agencia.viagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.agencia.viagem.model.Destino;
import com.agencia.viagem.model.Reserva;
import com.agencia.viagem.repository.DestinoRepository;
import com.agencia.viagem.repository.ReservaRepository;

@Service
public class DestinoService {

    private final DestinoRepository destinoRepository;
    private final ReservaRepository reservaRepository;

    public DestinoService(DestinoRepository destinoRepository, ReservaRepository reservaRepository) {
        this.destinoRepository = destinoRepository;
        this.reservaRepository = reservaRepository;
    }

    public Destino cadastrar(Destino destino) {
        return destinoRepository.save(destino);
    }

    public List<Destino> listar() {
        return destinoRepository.findAll();
    }

    public List<Destino> pesquisar(String termo) {
        return destinoRepository.findByNomeContainingIgnoreCaseOrLocalContainingIgnoreCase(termo, termo);
    }

    public Optional<Destino> detalhar(Long id) {
        return destinoRepository.findById(id);
    }

    public Optional<Destino> avaliar(Long id, int nota) {
        Optional<Destino> opt = destinoRepository.findById(id);
        opt.ifPresent(d -> {
            d.avaliar(nota);
            destinoRepository.save(d);
        });
        return opt;
    }

    public Optional<Destino> atualizar(Long id, Destino novo) {
        return destinoRepository.findById(id).map(d -> {
            d.setNome(novo.getNome());
            d.setLocal(novo.getLocal());
            d.setDescricao(novo.getDescricao());
            return destinoRepository.save(d);
        });
    }

    public void excluir(Long id) {
        destinoRepository.deleteById(id);
    }

    public Reserva reservar(Long destinoId, String nomeCliente, String data) {
        System.out.println(">>> Procurando destino com ID " + destinoId);

        Destino destino = destinoRepository.findById(destinoId)
            .orElseThrow(() -> new RuntimeException("Destino não encontrado"));
        Reserva reserva = new Reserva(null, nomeCliente, data, destino);
        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }
}