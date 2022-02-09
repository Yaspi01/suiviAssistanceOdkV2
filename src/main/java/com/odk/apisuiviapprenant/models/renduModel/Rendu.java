package com.odk.apisuiviapprenant.models.renduModel;

import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.models.briefModel.Brief;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Rendu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private LocalDate date = LocalDate.now();
    private String message;

    @ManyToOne
    private Apprenant apprenant;

    @OneToOne
    private Brief brief;

    public Rendu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }

    public Brief getBrief() {
        return brief;
    }

    public void setBrief(Brief brief) {
        this.brief = brief;
    }
}
