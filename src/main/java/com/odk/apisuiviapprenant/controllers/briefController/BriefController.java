package com.odk.apisuiviapprenant.controllers.briefController;

import com.odk.apisuiviapprenant.models.briefModel.Brief;
import com.odk.apisuiviapprenant.service.briefService.BriefServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
