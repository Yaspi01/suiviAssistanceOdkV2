package com.odk.apisuiviapprenant.service.briefService;

import com.odk.apisuiviapprenant.models.briefModel.Brief;

import java.util.List;

public interface BriefService {

    Brief addBrief(Brief brief);
    List<Brief> allBrief();
    Brief briefById(Long id);
    List<Brief> findBriefByApprenant(Long id);
    List<Brief> findBriefByFormateur(Long id);
}
