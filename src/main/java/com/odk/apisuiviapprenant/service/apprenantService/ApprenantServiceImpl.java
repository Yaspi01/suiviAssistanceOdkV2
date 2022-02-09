package com.odk.apisuiviapprenant.service.apprenantService;

import com.odk.apisuiviapprenant.Etat;
import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.repositories.apprenantRepository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class ApprenantServiceImpl implements ApprenantService{

    @Autowired
    ApprenantRepository apprenantRepository;

    @Override
    public Apprenant addApprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    @Override
    public List<Apprenant> allAprenants() {
        return apprenantRepository.findAll();
    }

    @Override
    public Apprenant apprenantById(Long id) {
        return apprenantRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void deleteApprenant(Long id) {
        Apprenant apprenant = apprenantRepository.findById(id).get();
        apprenant.setEtat(Etat.Desactiver);
        apprenant.setSupprimer(true);
    }

    @Override
    public Apprenant updateApprenant(Apprenant apprenant, Long id) {
        Apprenant apprenantFound = apprenantRepository.getById(id);
        apprenantFound.setPrenom(apprenant.getPrenom());
        apprenantFound.setNom(apprenant.getNom());
        apprenantFound.setLogin(apprenant.getLogin());
        apprenantFound.setEmail(apprenant.getEmail());
        apprenantFound.setGenre(apprenant.getGenre());
        apprenantFound.setEtat(apprenant.getEtat());
        apprenantFound.setSupprimer(apprenant.isSupprimer());
        apprenantFound.setAssister(apprenant.isAssister());
        apprenantFound.setTelephone(apprenant.getTelephone());
        apprenantFound.setMotDePass(apprenant.getMotDePass());
        return apprenantRepository.save(apprenantFound);
    }

    @Override
    public Apprenant authentification(String login, String motDePasse) {
        Optional<Apprenant> connexion = apprenantRepository.findApprenantByLoginAndMotDePass(login, motDePasse);

        if(connexion.isEmpty()){
            throw new IllegalStateException("Login ou mot de passe incorrect");
        }
        if(connexion.get().getEtat() == Etat.Desactiver || connexion.get().isSupprimer()){
            throw new IllegalStateException("Votre compte a été désactivé");
        }
        return connexion.get();
    }

    @Transactional
    @Override
    public void restaureAppre(Long id) {
        Apprenant apprenant = apprenantRepository.getById(id);
        apprenant.setEtat(Etat.Activer);
        apprenant.setSupprimer(false);
    }
}
