package com.odk.apisuiviapprenant.controllers.briefController;

import com.odk.apisuiviapprenant.models.briefModel.Brief;
import com.odk.apisuiviapprenant.service.briefService.BriefServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/brief")
public class BriefController {

    @Autowired
    BriefServiceImpl briefService;

    @PostMapping("/ajoutBrief")
    Brief addBrief(@RequestBody Brief brief){
        return briefService.addBrief(brief);
    }

    @GetMapping("/allBrief")
    List<Brief> allBrief(){
        return briefService.allBrief();
    }

    @GetMapping("/briefById/{id}")
    Brief briefById(@PathVariable("id")Long id){
        return briefService.briefById(id);
    }

    @GetMapping("/findBriefByApprenant/{apprenant}")
    List<Brief> findBriefByApprenant(@PathVariable("apprenant") String apprenant){
        return briefService.findBriefByApprenant(apprenant);
    }

    @GetMapping("/findBriefByFormateur/{formateur}")
    List<Brief> findBriefByFormateur(@PathVariable("formateur") String formateur){
        return briefService.findBriefByApprenant(formateur);
    }


}
