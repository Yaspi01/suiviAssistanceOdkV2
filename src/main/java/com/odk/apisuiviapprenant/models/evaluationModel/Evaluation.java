package com.odk.apisuiviapprenant.models.evaluationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odk.apisuiviapprenant.Niveau;
import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.models.briefModel.Brief;
import com.odk.apisuiviapprenant.models.matiereModel.Matiere;

import javax.persistence.*;
import java.util.List;

@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Niveau niveau;

    @OneToMany(mappedBy = "evaluation")
    @JsonIgnore
    private List<Brief> brief;

    @ManyToOne
    private Apprenant apprenant;

    public Evaluation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public List<Brief> getBrief() {
        return brief;
    }

    public void setBrief(List<Brief> brief) {
        this.brief = brief;
    }

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }
}
