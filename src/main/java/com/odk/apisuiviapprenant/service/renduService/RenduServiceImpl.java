package com.odk.apisuiviapprenant.service.renduService;

import com.odk.apisuiviapprenant.models.renduModel.Rendu;
import com.odk.apisuiviapprenant.repositories.renduRepository.RenduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenduServiceImpl implements RenduService{

    @Autowired
    RenduRepository renduRepository;

    @Override
    public Rendu addRendu(Rendu rendu) {
        return renduRepository.save(rendu);
    }

    @Override
    public List<Rendu> allRendu() {
        return renduRepository.findAll();
    }

    @Override
    public Rendu renduById(Long id) {
        return renduRepository.findById(id).get();
    }

    @Override
    public Rendu updateRendu(Rendu rendu, Long id) {
        Rendu renduFound = renduRepository.getById(id);
        renduFound.setUrl(rendu.getUrl());
        renduFound.setMessage(rendu.getMessage());
        renduFound.setDate(rendu.getDate());
        return renduRepository.save(renduFound);
    }
}
