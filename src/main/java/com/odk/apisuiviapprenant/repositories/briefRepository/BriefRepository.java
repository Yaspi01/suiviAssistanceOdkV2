package com.odk.apisuiviapprenant.repositories.briefRepository;

import com.odk.apisuiviapprenant.models.briefModel.Brief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BriefRepository extends JpaRepository<Brief, Long> {
    @Query(value = "SELECT apprenant FROM Brief apprenant WHERE apprenant.apprenant.nom = :apprenant")
    List<Brief> findBriefByApprenant(@Param("apprenant") String apprenant);
    @Query(value = "SELECT formateur FROM Brief formateur WHERE formateur.formateur.nom = :formateur")
    List<Brief> findBriefByFormateur(@Param("formateur") String formateur);
}
