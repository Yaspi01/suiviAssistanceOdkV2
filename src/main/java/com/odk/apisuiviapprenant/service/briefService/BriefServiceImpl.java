package com.odk.apisuiviapprenant.service.briefService;

import com.odk.apisuiviapprenant.models.briefModel.Brief;
import com.odk.apisuiviapprenant.repositories.briefRepository.BriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BriefServiceImpl implements BriefService {

    @Autowired
    BriefRepository briefRepository;

    @Override
    public Brief addBrief(Brief brief) {
        return briefRepository.save(brief);
    }

    @Override
    public List<Brief> allBrief() {
        return briefRepository.findAll();
    }

    @Override
    public Brief briefById(Long id) {
        return briefRepository.findById(id).get();
    }
}
