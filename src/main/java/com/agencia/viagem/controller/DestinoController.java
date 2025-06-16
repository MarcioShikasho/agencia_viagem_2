package com.agencia.viagem.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.viagem.model.Destino;
import com.agencia.viagem.model.Reserva;
import com.agencia.viagem.service.DestinoService;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

    private final DestinoService service;

    public DestinoController(DestinoService service) {
        this.service = service;
    }

    @PostMapping
    public Destino criar(@RequestBody Destino destino) {
        return service.cadastrar(destino);
    }

    @GetMapping
    public List<Destino> listar() {
        return service.listar();
    }

    @GetMapping("/buscar")
    public List<Destino> buscar(@RequestParam String termo) {
        return service.pesquisar(termo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> detalhar(@PathVariable Long id) {
        return service.detalhar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/avaliar")
    public ResponseEntity<Destino> avaliar(@PathVariable Long id, @RequestParam int nota) {
        return service.avaliar(id, nota)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/reservar")
    public ResponseEntity<Reserva> reservar(@PathVariable Long id, @RequestBody Reserva reservaRequisicao) {
        Reserva reserva = service.reservar(id, reservaRequisicao.getNomeCliente(), reservaRequisicao.getData());
        return ResponseEntity.ok(reserva);
    }

    @GetMapping("/reservas")
    public List<Reserva> listarReservas() {
        return service.listarReservas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destino> atualizar(@PathVariable Long id, @RequestBody Destino destinoAtualizado) {
        return service.atualizar(id, destinoAtualizado)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}