package com.odk.apisuiviapprenant.service.apprenantService;

import com.odk.apisuiviapprenant.Etat;
import com.odk.apisuiviapprenant.Type;
import com.odk.apisuiviapprenant.exception.ErrorCode;
import com.odk.apisuiviapprenant.exception.InvalidEntityException;
import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.repositories.apprenantRepository.ApprenantRepository;
import com.odk.apisuiviapprenant.validators.ApprenantValidators;
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
        apprenant.setType(Type.Apprenant);
        apprenant.setEtat(Etat.Activer);
        List<String> errors = ApprenantValidators.validate(apprenant);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("L'apprenant que vous avez saisi n'est pas valid", ErrorCode.APPRENANT_NOT_VALID, errors);
        }
        List<Apprenant> apprenantEmail = apprenantRepository.findApprenantByEmail(apprenant.getEmail());
        if (!apprenantEmail.isEmpty()){
            throw new InvalidEntityException("Un autre apprenant avec cette adresse email existe dejà", ErrorCode.APPRENANT_ALREADY_EXISTE, errors);
        }

        List<Apprenant> apprenantLogin = apprenantRepository.findApprenantByLogin(apprenant.getLogin());
        if (!apprenantLogin.isEmpty()){
            throw new InvalidEntityException("Un autre apprenant avec ce login existe dejà", ErrorCode.APPRENANT_ALREADY_EXISTE, errors);
        }

        List<Apprenant> apprenantTelephone = apprenantRepository.findApprenantByTelephone(apprenant.getTelephone());
        if (!apprenantTelephone.isEmpty()){
            throw new InvalidEntityException("Un autre apprenant avec ce numéro de téléphone existe dejà", ErrorCode.APPRENANT_ALREADY_EXISTE, errors);
        }
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
            return null;
            //throw new InvalidEntityException("Login ou mot de passe incorrect", ErrorCode.APPRENANT_AUTHENTIFICATION_INVALID);
        }
        /*if(connexion.get().getEtat() == Etat.Desactiver || connexion.get().isSupprimer()){
            throw new InvalidEntityException("Votre compte a été supprimé", ErrorCode.APPRENANT_DESACTIVE_ACCOUNT);
        }
         */
        return connexion.get();
    }

    @Transactional
    @Override
    public void restaureAppre(Long id) {
        Apprenant apprenant = apprenantRepository.getById(id);
        apprenant.setEtat(Etat.Activer);
        apprenant.setSupprimer(false);
    }

    @Override
    public List<Apprenant> findApprenantByAssister(boolean assis) {
        return apprenantRepository.findApprenantByAssister(assis);
    }

    @Override
    public List<Apprenant> findApprenantNoByAssister(boolean assis) {
        return apprenantRepository.findApprenantByNonAssister(assis);
    }
}
