package com.agencia.viagem.repository;

import com.agencia.viagem.model.Reserva;
import com.agencia.viagem.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByDestino(Destino destino);
}