package com.odk.apisuiviapprenant.repositories.evaluationRepository;

import com.odk.apisuiviapprenant.models.evaluationModel.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
