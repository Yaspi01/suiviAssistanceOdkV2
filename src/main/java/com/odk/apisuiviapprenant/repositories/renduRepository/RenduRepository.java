package com.odk.apisuiviapprenant.repositories.renduRepository;

import com.odk.apisuiviapprenant.models.renduModel.Rendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RenduRepository extends JpaRepository<Rendu, Long> {

    @Query(value = "SELECT red FROM Rendu red WHERE red.brief.id = :id")
    List<Rendu> renduByBrief(@Param("id") Long id);
}
