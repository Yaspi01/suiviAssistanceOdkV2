package com.odk.apisuiviapprenant.controllers.matiereController;

import com.odk.apisuiviapprenant.models.matiereModel.Matiere;
import com.odk.apisuiviapprenant.service.matiereService.MatiereServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class MatiereController {

    @Autowired
    MatiereServiceImpl matiereService;

    @PostMapping("addMatiere")
    Matiere addMatiere(@RequestBody Matiere matiere){
        return matiereService.addMatiere(matiere);
    }

    @GetMapping("allMatiere")
    List<Matiere> allMatiere(){
        return matiereService.allMatiere();
    }

    @GetMapping("matiereById/{id}")
    Matiere matiereById(@PathVariable("id") Long id){
        return matiereService.matiereById(id);
    }

    @PutMapping("updateMatiere/{id}")
    Matiere updateMatiere(@PathVariable("id") Long id, @RequestBody Matiere matiere){
        return matiereService.updateMatiere(matiere, id);
    }
}
