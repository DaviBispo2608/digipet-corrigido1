package com.digipet.care.repository;

import com.digipet.care.domain.Escala;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.DayOfWeek;
import java.util.List;

public interface EscalaRepository extends JpaRepository<Escala, Long> {
    List<Escala> findByProfissionalId(Long profissionalId);
    List<Escala> findByProfissionalIdAndDiaSemanaAndAtivoTrue(Long profissionalId, DayOfWeek diaSemana);
}