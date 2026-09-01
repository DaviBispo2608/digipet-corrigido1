package com.digipet.care.repository;

import com.digipet.care.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // A MÁGICA DO MULTI-TENANCY AQUI:
    // Nenhuma query deve ser feita sem filtrar por clinicaId!
    List<Agendamento> findAllByClinicaId(Long clinicaId);

    // Busca agendamentos de um profissional específico dentro da clínica
    List<Agendamento> findByClinicaIdAndProfissionalId(Long clinicaId, Long profissionalId);

    boolean existsByClinicaIdAndProfissionalIdAndDataHoraLessThanAndDataHoraFimGreaterThan(
            Long clinicaId, Long profissionalId, LocalDateTime fim, LocalDateTime inicio);
}
