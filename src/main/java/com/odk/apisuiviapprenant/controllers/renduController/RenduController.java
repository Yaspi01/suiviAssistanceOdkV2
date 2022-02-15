package com.odk.apisuiviapprenant.controllers.renduController;

import com.odk.apisuiviapprenant.models.renduModel.Rendu;
import com.odk.apisuiviapprenant.service.renduService.RenduServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class RenduController {

    @Autowired
    RenduServiceImpl renduService;

    @PostMapping("addRendu")
    Rendu addRendu(@RequestBody Rendu rendu){
        return renduService.addRendu(rendu);
    }

    @GetMapping("allRendu")
    List<Rendu> allRendu(){
        return renduService.allRendu();
    }

    @GetMapping("renduById/{id}")
    Rendu renduById(@PathVariable("id") Long id){
        return renduService.renduById(id);
    }

    @PutMapping("updateRendu/{id}")
    Rendu updateRendu(@RequestBody Rendu rendu, @PathVariable("id") Long id){
        return renduService.updateRendu(rendu, id);
    }
    @GetMapping("renduByBriefAndApprenant/{id}")
    List<Rendu> renduByBriefAndApprenant(@PathVariable("id") Long id){
        return renduService.renduByBriefAndApprenant(id);
    }
}
