package com.odk.apisuiviapprenant.models.matiereModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odk.apisuiviapprenant.models.briefModel.Brief;
import com.odk.apisuiviapprenant.models.evaluationModel.Evaluation;
import com.odk.apisuiviapprenant.models.formateurModel.Formateur;

import javax.persistence.*;
import java.util.List;

@Entity
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom_matiere;

    private String photo;

    @ManyToOne
    private Formateur formateur;

    @OneToMany
    @JsonIgnore
    private List<Evaluation> evaluation;

    @OneToMany
    @JsonIgnore
    private List<Brief> brief;

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

    public List<Evaluation> getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(List<Evaluation> evaluation) {
        this.evaluation = evaluation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Brief> getBrief() {
        return brief;
    }

    public void setBrief(List<Brief> brief) {
        this.brief = brief;
    }
}
