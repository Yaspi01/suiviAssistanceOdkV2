package com.odk.apisuiviapprenant.service.evaluationService;

import com.odk.apisuiviapprenant.models.evaluationModel.Evaluation;
import com.odk.apisuiviapprenant.repositories.evaluationRepository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService{

    @Autowired
    EvaluationRepository evaluationRepository;

    @Override
    public Evaluation addEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @Override
    public List<Evaluation> allEvaluation() {
        return evaluationRepository.findAll();
    }

    @Override
    public Evaluation evaluationById(Long id) {
        return evaluationRepository.getById(id);
    }

    @Override
    public Evaluation updateEvaluation(Evaluation evaluation, Long id) {
        Evaluation evaluationFound = evaluationRepository.getById(id);
        evaluationFound.setNiveau(evaluation.getNiveau());
        return evaluationRepository.save(evaluationFound);
    }

    @Override
    public List<Evaluation> findEvaluationByApprenant(Long id) {
        return evaluationRepository.findEvaluationByApprenant(id);
    }
}
