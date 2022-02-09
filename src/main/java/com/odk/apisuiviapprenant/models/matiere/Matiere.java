package com.odk.apisuiviapprenant.models.matiere;

import com.odk.apisuiviapprenant.models.formateurModel.Formateur;

import javax.persistence.*;
import java.util.List;

@Entity
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom_matiere;

    @ManyToOne
    private Formateur formateur;
}
