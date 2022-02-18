package com.odk.apisuiviapprenant.service.renduService;

import com.odk.apisuiviapprenant.models.renduModel.Rendu;

import java.util.List;

public interface RenduService {

    Rendu addRendu(Rendu rendu);
    List<Rendu> allRendu();
    Rendu renduById(Long id);
    Rendu updateRendu(Rendu rendu, Long id);
    List<Rendu> renduByBrief(Long id);
}
