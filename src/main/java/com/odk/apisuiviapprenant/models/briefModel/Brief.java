package com.odk.apisuiviapprenant.models.briefModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.models.formateurModel.Formateur;
import com.odk.apisuiviapprenant.models.matiereModel.Matiere;
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

    private String photo;

    private String description;

    @ManyToOne
    private Formateur formateur;

    @OneToOne
    private Apprenant apprenant;

    @OneToMany(mappedBy = "brief")
    @JsonIgnore
    private List<Rendu> rendu;

    @ManyToOne
    private Matiere matiere;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public List<Rendu> getRendu() {
        return rendu;
    }

    public void setRendu(List<Rendu> rendu) {
        this.rendu = rendu;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
}
