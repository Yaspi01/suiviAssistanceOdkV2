package com.odk.apisuiviapprenant.models.briefModel;

import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.models.formateurModel.Formateur;
import com.odk.apisuiviapprenant.models.renduModel.Rendu;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Brief {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private LocalDate date = LocalDate.now();

    private String description;

    @ManyToOne
    private Formateur formateur;

    @OneToOne
    private Apprenant apprenant;

    @OneToOne(mappedBy = "brief")
    private Rendu rendu;
    public Brief() {
    }

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Rendu getRendu() {
        return rendu;
    }

    public void setRendu(Rendu rendu) {
        this.rendu = rendu;
    }
}
