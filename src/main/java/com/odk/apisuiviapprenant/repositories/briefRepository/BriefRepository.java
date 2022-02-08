package com.odk.apisuiviapprenant.repositories.briefRepository;

import com.odk.apisuiviapprenant.models.briefModel.Brief;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BriefRepository extends JpaRepository<Brief, Long> {
}
