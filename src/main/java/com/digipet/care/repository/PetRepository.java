package com.digipet.care.repository;

import com.digipet.care.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByDonoId(Long donoId);
    boolean existsByIdAndDonoClinicaId(Long id, Long clinicaId);
}
