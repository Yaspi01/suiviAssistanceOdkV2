package com.odk.apisuiviapprenant.service.formateurService;

import com.odk.apisuiviapprenant.Etat;
import com.odk.apisuiviapprenant.models.formateurModel.Formateur;
import com.odk.apisuiviapprenant.repositories.formateurRepository.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormateurServiceImpl implements FormateurService{

    @Autowired
    FormateurRepository formateurRepository;

    @Override
    public Formateur addFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> allFormateur() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur authentification(String login, String motDePasse) {
        Optional<Formateur> getFormateur = formateurRepository.findFormateurByLoginAndMotDePass(login, motDePasse);
        if(getFormateur.isEmpty()){
            throw new IllegalStateException("Login ou mot de passe");
        }
        if (getFormateur.get().getEtat() == Etat.Desactiver){
            throw new IllegalStateException("Votre compte a été supprimé");
        }
        return getFormateur.get();
    }

    @Override
    public Formateur formateurById(Long id) {
        return formateurRepository.findById(id).get();
    }
}
