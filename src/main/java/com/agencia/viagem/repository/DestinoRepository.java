package com.agencia.viagem.repository;

import com.agencia.viagem.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DestinoRepository extends JpaRepository<Destino, Long> {
    List<Destino> findByNomeContainingIgnoreCaseOrLocalContainingIgnoreCase(String nome, String local);
}