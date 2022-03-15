package com.odk.apisuiviapprenant.service.evaluationService;

import com.odk.apisuiviapprenant.enums.Niveau;
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
        return evaluationRepository.findById(id).get();
    }

    @Override
    public Evaluation updateEvaluation(Evaluation evaluation, Long id) {
        Evaluation evaluationFound = evaluationRepository.findById(id).get();
        evaluationFound.setNiveau(evaluation.getNiveau());
        evaluationFound.setApprenant(evaluation.getApprenant());
        evaluationFound.setMatiere(evaluationFound.getMatiere());
        evaluationFound.setBrief(evaluation.getBrief());
        return evaluationRepository.save(evaluationFound);
    }

    @Override
    public Evaluation updateNote(Evaluation evaluation, Long id){
        Evaluation evaluationFound = evaluationRepository.findById(id).get();
        evaluationFound.setNote(evaluation.getNote());
        evaluationFound.setNiveau(evaluation.getNiveau());
        evaluationFound.setApprenant(evaluation.getApprenant());
        evaluationFound.setMatiere(evaluationFound.getMatiere());
        evaluationFound.setBrief(evaluation.getBrief());
        if (evaluation.getNote() >= 15){
            evaluationFound.setNiveau(Niveau.Avancé);
        }
        if (evaluationFound.getNote() >= 10 && evaluationFound.getNote() < 15){
            evaluationFound.setNiveau(Niveau.Moyen);
        }
        if (evaluationFound.getNote() < 10){
            evaluationFound.setNiveau(Niveau.Faible);
        }
        if (evaluationFound.getNote() > 20){
           return null;
        }
        return evaluationRepository.save(evaluationFound);
    }

    @Override
    public List<Evaluation> findEvaluationByApprenant(Long id) {
        return evaluationRepository.findEvaluationByApprenant(id);
    }

    @Override
    public List<Evaluation> findEvaluationByMatiere(Long id) {
        return evaluationRepository.findEvaluationByMatiere(id);
    }
}
