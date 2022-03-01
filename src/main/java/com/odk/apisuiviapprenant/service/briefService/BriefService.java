package com.odk.apisuiviapprenant.service.briefService;

import com.odk.apisuiviapprenant.models.briefModel.Brief;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BriefService {

    Brief addBrief(Brief brief, MultipartFile file) throws IOException;
    List<Brief> allBrief();
    Brief briefById(Long id);
    List<Brief> findBriefByApprenant(Long id);
    List<Brief> findBriefByFormateur(Long id);
}
