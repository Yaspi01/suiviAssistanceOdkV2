package com.odk.apisuiviapprenant.models.matiereModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odk.apisuiviapprenant.models.evaluationModel.Evaluation;
import com.odk.apisuiviapprenant.models.formateurModel.Formateur;

import javax.persistence.*;

@Entity
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom_matiere;

    @ManyToOne
    private Formateur formateur;

    @OneToOne(mappedBy = "matiere", orphanRemoval = true)
    @JsonIgnore
    private Evaluation evaluation;

    public Matiere() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
}
