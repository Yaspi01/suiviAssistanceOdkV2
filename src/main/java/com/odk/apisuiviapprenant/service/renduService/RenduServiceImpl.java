package com.odk.apisuiviapprenant.service.renduService;

import com.odk.apisuiviapprenant.models.authers.Constante;
import com.odk.apisuiviapprenant.models.renduModel.Rendu;
import com.odk.apisuiviapprenant.repositories.renduRepository.RenduRepository;
import com.odk.apisuiviapprenant.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RenduServiceImpl implements RenduService{

    @Autowired
    RenduRepository renduRepository;
    @Autowired
    MailSenderService senderService;

    @Override
    public Rendu addRendu(Rendu rendu) {
        rendu.getBrief().setStatus(true);
        return renduRepository.save(rendu);
    }

    @Override
    public List<Rendu> allRendu() {
        return renduRepository.findAll();
    }

    @Override
    @Transactional
    public Rendu renduById(Long id) {
        return renduRepository.findById(id).get();
    }

    @Override
    public Rendu updateRendu(Rendu rendu, Long id) {
        Rendu renduFound = renduRepository.findById(id).get();
        renduFound.setUrl(rendu.getUrl());
        renduFound.setMessage(rendu.getMessage());
        renduFound.setDate(rendu.getDate());
        renduFound.setApprenant(rendu.getApprenant());
        renduFound.setBrief(rendu.getBrief());
        renduFound.setStatus(rendu.isStatus());
        return renduRepository.save(renduFound);
    }

    @Override
    public List<Rendu> renduByBrief(Long id) {
        return renduRepository.renduByBrief(id);
    }

    @Override
    public List<Rendu> renduByApprenant(Long id) {
        return renduRepository.renduByApprenant(id);
    }

    @Override
    public Rendu updateRenduStatus(Rendu rendu, Long id) {
        rendu = renduRepository.findById(id).get();
        rendu.setStatus(true);
        return renduRepository.save(rendu);
    }
}
