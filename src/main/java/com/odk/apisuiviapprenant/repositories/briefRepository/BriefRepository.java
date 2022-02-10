package com.odk.apisuiviapprenant.repositories.briefRepository;

import com.odk.apisuiviapprenant.models.briefModel.Brief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BriefRepository extends JpaRepository<Brief, Long> {
    @Query(value = "SELECT id FROM Brief id WHERE id.apprenant.id = :id")
    List<Brief> findBriefByApprenant(@Param("id") Long id);
    @Query(value = "SELECT id FROM Brief id WHERE id.formateur.id = :id")
    List<Brief> findBriefByFormateur(@Param("id") Long id);
}
