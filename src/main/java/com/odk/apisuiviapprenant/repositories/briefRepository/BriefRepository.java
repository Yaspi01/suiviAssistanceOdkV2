package com.odk.apisuiviapprenant.repositories.briefRepository;

import com.odk.apisuiviapprenant.models.briefModel.Brief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BriefRepository extends JpaRepository<Brief, Long> {
    //@Query(value = "SELECT b FROM Brief WHERE b.apprenant = :apprenant")
    List<Brief> findBriefByApprenant(@Param("b") String b);
}
